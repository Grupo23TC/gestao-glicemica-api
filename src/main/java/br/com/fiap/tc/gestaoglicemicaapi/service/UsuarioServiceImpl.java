package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.exception.UsuarioNotFoundException;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //TODO ver qual o campo será definido como identificador único
    @Override
    public void validaUsuario(Usuario usuario) throws RuntimeException {
        Usuario usuarioId = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("error"));
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioDTO buscarPorId(Long usuarioId) {
        System.out.println(usuarioId);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));
        return toDTO(usuario);
    }

    @Transactional
    @Override
    public UsuarioDTO criar(Usuario usuarioBody) {
        return toDTO(usuarioRepository.save(usuarioBody));
    }

    @Transactional
    @Override
    public UsuarioDTO atualizar(Long usuarioId, Usuario usuario) {
        Usuario usuarioBuscado = usuarioRepository.getReferenceById(usuarioId);
        usuarioBuscado.setNome(usuario.getNome());
        return toDTO(usuarioRepository.save(usuarioBuscado));
    }

    @Transactional
    @Override
    public void deletar(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getSexo(),
            usuario.getIdade(),
            usuario.getCategoriaDiabete()
        );
    }
}
