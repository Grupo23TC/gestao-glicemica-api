package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoMinDTO;
import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RegistroGlicemicoService {
  Page<RegistroGlicemicoDTO> listarRegistros(Pageable pageable);

  RegistroGlicemicoDTO buscarPeloId(Long idRegistroGlicemico);

  RegistroGlicemicoDTO criar(RegistroGlicemicoMinDTO registroGlicemico);

  void deletar(Long idRegistroGlicemico);

  RegistroGlicemicoDTO atualizar(Long idRegistroGlicemico, RegistroGlicemicoMinDTO rg);

  List<RegistroGlicemico> registrosDoUsuario(Long usuarioId, LocalDateTime dataIni, LocalDateTime dataFim);

  Page<RegistroGlicemico> registroUsuario(Long usuarioId, Pageable pageable);
}
