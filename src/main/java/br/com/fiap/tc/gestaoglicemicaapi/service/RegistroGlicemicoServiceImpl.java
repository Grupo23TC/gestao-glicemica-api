package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroGlicemicoServiceImpl implements RegistroGlicemicoService {

    @Autowired
    private RegistroGlicemicoRepository rgRepository;

    @Override
    public RegistroGlicemico atualizar(Long idRegistroGlicemico, RegistroGlicemico rg) {
        Optional<RegistroGlicemico> rgSalvo = rgRepository.findById(idRegistroGlicemico);
        if (rgSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(rg, rgSalvo.get(), "idRegistroGlicemico");
        return rgRepository.save(rgSalvo.get());
    }

    public List<RegistroGlicemico> registrosDoUsuario(Long usuarioId) {
        List<RegistroGlicemico> registrosGlicemicos = rgRepository.findByUsuarioId(usuarioId);
        return registrosGlicemicos;
    }
}
