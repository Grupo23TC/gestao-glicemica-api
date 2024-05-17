package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception.UsuarioNotFoundException;
import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegistroGlicemicoService rgService;

    //TODO ver qual o campo será definido como identificador único
    @Override
    public void validaUsuario(Usuario usuario) {
      Usuario usuarioId = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new UsuarioNotFoundException(usuario.getId()));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listaUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::toDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioDTO buscarPorId(Long usuarioId) {
      // TODO implementar o método validarUsuario aqui :D
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
      // TODO implementar o método validarUsuario aqui :D
      Usuario usuarioBuscado = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));
      usuarioBuscado.setNome(usuario.getNome());
      usuarioBuscado.setSexo(usuario.getSexo());
      usuarioBuscado.setIdade(usuario.getIdade());
      usuarioBuscado.setCategoriaDiabete(usuario.getCategoriaDiabete());
      return toDTO(usuarioRepository.save(usuarioBuscado));
    }

    @Transactional
    @Override
    public void deletar(Long usuarioId) {
        Page<RegistroGlicemico> rgPage = rgService.registrosDoUsuario(usuarioId, Pageable.unpaged());
        if (rgPage.hasContent()) {
            rgPage.get().forEach(rg -> {
                rgService.deletar(rg.getId());
            });
        }
        usuarioRepository.deleteById(usuarioId);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getNome(),
            usuario.getSexo(),
            usuario.getIdade(),
            usuario.getCategoriaDiabete()
        );
    }
}
