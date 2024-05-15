package br.com.fiap.tc.gestaoglicemicaapi.controller;

import br.com.fiap.tc.gestaoglicemicaapi.dto.UsuarioDTO;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioSerivce;

    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioSerivce.listaUsuario();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioSerivce.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Validated @RequestBody Usuario usuario) throws Exception {
        // service.validaUsuario(usuario);
        UsuarioDTO usuarioSalvo = usuarioSerivce.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        return ResponseEntity.ok(usuarioSerivce.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioSerivce.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
