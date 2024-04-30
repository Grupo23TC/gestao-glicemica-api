package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RegistroGlicemicoServiceImpl implements RegistroGlicemicoService {

    @Autowired
    private RegistroGlicemicoRepository rgRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<RegistroGlicemico> listarEventos(Pageable pageable) {
        return rgRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RegistroGlicemico> buscarPeloId(Long idRegistroGlicemico) {
      return rgRepository.findById(idRegistroGlicemico);
    }

    @Override
    @Transactional
    public RegistroGlicemico criar(RegistroGlicemico registroGlicemico) {
      return rgRepository.save(registroGlicemico);
    }

    @Override
    @Transactional
    public void deletar(Long idRegistroGlicemico) {
        rgRepository.deleteById(idRegistroGlicemico);
    }

    @Override
    @Transactional
    public RegistroGlicemico atualizar(Long idRegistroGlicemico, RegistroGlicemico rg) {
        Optional<RegistroGlicemico> rgSalvo = rgRepository.findById(idRegistroGlicemico);
        if (rgSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(rg, rgSalvo.get(), "id");
        return rgRepository.save(rgSalvo.get());
    }
}
