package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;

import java.util.List;

public interface UsuarioService {
  void validaUsuario(Usuario usuario) throws RuntimeException;

  UsuarioDTO buscarPorId(Long usuarioId);

  UsuarioDTO criar(Usuario usuarioBody);

  UsuarioDTO atualizar(Long usuarioId, Usuario usuario);

  void deletar(Long usuarioId);

  List<UsuarioDTO> listaUsuario();
}
