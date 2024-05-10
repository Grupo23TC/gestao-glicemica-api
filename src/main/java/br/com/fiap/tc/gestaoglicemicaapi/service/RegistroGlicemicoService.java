package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoMinDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import br.com.fiap.tc.gestaoglicemicaapi.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroGlicemicoService  {

    @Autowired
    private RegistroGlicemicoRepository rgRepository;

    @Autowired
    private UsuarioRepository uRepository;


    @Transactional(readOnly = true)
    public Page<RegistroGlicemico> listarEventos(Pageable pageable) {
        return rgRepository.findAll(pageable);
    }


    @Transactional(readOnly = true)
    public RegistroGlicemicoDTO buscarPeloId(Long idRegistroGlicemico) throws RuntimeException {
        RegistroGlicemico rg = rgRepository.findById(idRegistroGlicemico).orElseThrow(() -> new RuntimeException("error"));
        return toDTO(rg);
    }

    @Transactional
    public RegistroGlicemicoDTO criar(RegistroGlicemicoMinDTO registroGlicemico) {
        Usuario usuario = uRepository.getReferenceById(registroGlicemico.usuarioId());
        RegistroGlicemico rg = new RegistroGlicemico(
            registroGlicemico.titulo(),
            registroGlicemico.valorGlicemia(),
            registroGlicemico.observacao(),
            usuario
            );
        return toDTO(rgRepository.save(rg));
    }

    @Transactional
    public void deletar(Long idRegistroGlicemico) {
        rgRepository.deleteById(idRegistroGlicemico);
    }

    @Transactional
    public RegistroGlicemicoDTO atualizar(Long idRegistroGlicemico, RegistroGlicemico rg) {
        Optional<RegistroGlicemico> rgSalvo = rgRepository.findById(idRegistroGlicemico);
        if (rgSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(rg, rgSalvo.get(), "id");
        return toDTO(rgRepository.save(rgSalvo.get()));
    }

    private RegistroGlicemicoDTO toDTO(RegistroGlicemico entity) {
        return new RegistroGlicemicoDTO(
            entity.getId(),
            entity.getTitulo(),
            entity.getValorGlicemia(),
            entity.getObservacao(),
            new UsuarioDTO(
                entity.getUsuario().getId(),
                entity.getUsuario().getNome(),
                entity.getUsuario().getSexo(),
                entity.getUsuario().getIdade(),
                entity.getUsuario().getCategoriaDiabete()
            )
        );
    }
}
