package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface RegistroGlicemicoService {

    Page<RegistroGlicemico> listarEventos(Pageable pageable);

    Optional<RegistroGlicemico> buscarPeloId(Long idRegistroGlicemico);

    RegistroGlicemico criar (RegistroGlicemico registroGlicemico);

    void deletar(Long idRegistroGlicemico);

    public RegistroGlicemico atualizar(Long idRegistroGlicemico, RegistroGlicemico rg);

}
