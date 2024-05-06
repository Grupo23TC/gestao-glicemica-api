package br.com.fiap.tc.gestaoglicemicaapi.repository;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroGlicemicoRepository extends JpaRepository<RegistroGlicemico, Long> {

        List<RegistroGlicemico> findByUsuarioId(Long usuarioId);
}
