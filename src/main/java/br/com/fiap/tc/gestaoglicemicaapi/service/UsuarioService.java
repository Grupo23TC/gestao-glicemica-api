package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import org.springframework.stereotype.Service;


public interface UsuarioService {

    public void validaUsuario(Usuario usuario) throws Exception;

    public Usuario buscarPorId(Long usuarioId);
}
