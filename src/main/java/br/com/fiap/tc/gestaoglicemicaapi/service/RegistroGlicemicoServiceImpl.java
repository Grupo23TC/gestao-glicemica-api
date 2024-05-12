package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoMinDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.exception.RegistroGlicemicoNotFoundException;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroGlicemicoServiceImpl implements RegistroGlicemicoService {

    @Autowired
    private RegistroGlicemicoRepository rgRepository;

    @Autowired
    private UsuarioRepository uRepository;


    @Transactional(readOnly = true)
    @Override
    public Page<RegistroGlicemicoDTO> listarRegistros(Pageable pageable) {
        return rgRepository.findAll(pageable).map(this::toDTO);
    }


    @Transactional(readOnly = true)
    @Override
    public RegistroGlicemicoDTO buscarPeloId(Long idRegistroGlicemico) {
        RegistroGlicemico rg = rgRepository.findById(idRegistroGlicemico).orElseThrow(() -> new RegistroGlicemicoNotFoundException("Registro Glicemico não encontrado"));
        return toDTO(rg);
    }

    @Transactional
    @Override
    public RegistroGlicemicoDTO criar(RegistroGlicemicoMinDTO rgDTO) {
        Usuario usuario = uRepository.getReferenceById(rgDTO.usuarioId());
        RegistroGlicemico rg = new RegistroGlicemico(
            rgDTO.titulo(),
            rgDTO.valorGlicemia(),
            rgDTO.data(),
            rgDTO.observacao(),
            usuario
            );
        return toDTO(rgRepository.save(rg));
    }

    @Transactional
    @Override
    public void deletar(Long idRegistroGlicemico) {
        rgRepository.deleteById(idRegistroGlicemico);
    }

    @Transactional
    @Override
    public RegistroGlicemicoDTO atualizar(Long idRegistroGlicemico, RegistroGlicemicoMinDTO rg) {
        Optional<RegistroGlicemico> rgSalvo = rgRepository.findById(idRegistroGlicemico);
        if (rgSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(rg, rgSalvo.get(), "id");
        return toDTO(rgRepository.save(rgSalvo.get()));
    }

    @Transactional(readOnly = true)
    public List<RegistroGlicemico> registrosDoUsuario(Long usuarioId, LocalDateTime dataIni, LocalDateTime dataFim) {
        List<RegistroGlicemico> registrosGlicemicos = rgRepository.findByUsuarioIdAndDataBetween(usuarioId, dataIni, dataFim);
        return registrosGlicemicos;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<RegistroGlicemico> registroUsuario(Long usuarioId, Pageable pageable) {
      return rgRepository.findByUsuarioId(usuarioId, pageable);
    }

    private RegistroGlicemicoDTO toDTO(RegistroGlicemico entity) {
        return new RegistroGlicemicoDTO(
            entity.getId(),
            entity.getTitulo(),
            entity.getValorGlicemia(),
            entity.getData(),
            entity.getObservacao(),
            new UsuarioDTO(
                entity.getUsuario().getNome(),
                entity.getUsuario().getSexo(),
                entity.getUsuario().getIdade(),
                entity.getUsuario().getCategoriaDiabete()
            )
        );
    }
}
