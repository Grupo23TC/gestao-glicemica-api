package br.com.fiap.tc.gestaoglicemicaapi.repository;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroGlicemicoRepository extends JpaRepository<RegistroGlicemico, Long> {

}
