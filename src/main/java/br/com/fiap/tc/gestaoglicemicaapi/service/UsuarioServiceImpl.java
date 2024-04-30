package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //TODO ver qual o campo será definido como identificador único
    public void validaUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> usuarioId = usuarioRepository.findById(usuario.getId());

        if(usuarioId.isPresent()) {
            throw new Exception();
        }
    }
}
