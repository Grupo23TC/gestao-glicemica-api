package br.com.fiap.tc.gestaoglicemicaapi.controller;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Usuario;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import br.com.fiap.tc.gestaoglicemicaapi.repository.UsuarioRepository;
import br.com.fiap.tc.gestaoglicemicaapi.service.RegistroGlicemicoService;
import br.com.fiap.tc.gestaoglicemicaapi.service.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/rg")
public class RegistroGlicemicoController {

    @Autowired
    private RegistroGlicemicoRepository rgRepository;

    @Autowired
    private RegistroGlicemicoService service;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listaRg")
    public ResponseEntity<List<RegistroGlicemico>> listarEventos() {
        List<RegistroGlicemico> rg = rgRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(rg);
    }

    @GetMapping("/{idRegistroGlicemico}")
    public ResponseEntity<Optional<RegistroGlicemico>> buscarPeloId(@PathVariable Long idRegistroGlicemico) {
        Optional<RegistroGlicemico> rg = rgRepository.findById(idRegistroGlicemico);
        return !rg.isEmpty() ? ResponseEntity.ok(rg) : ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RegistroGlicemico>> listarRegistrosPorIdUsuario(@PathVariable Long usuarioId) {
        List<RegistroGlicemico> rg = rgRepository.findByUsuarioId(usuarioId);
        return !rg.isEmpty() ? ResponseEntity.ok(rg) : ResponseEntity.noContent().build();
    }

    @PostMapping("/{usuarioId}")
    public ResponseEntity<RegistroGlicemico> criar(@Validated @RequestBody RegistroGlicemico rg, @PathVariable Long usuarioId, HttpServletResponse response) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        rg.setUsuario(usuario);

        RegistroGlicemico rgSalvo = rgRepository.save(rg);
        return ResponseEntity.status(HttpStatus.CREATED).body(rgSalvo);
    }

    @DeleteMapping("/{idRegistroGlicemico}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long idRegistroGlicemico) {
        rgRepository.deleteById(idRegistroGlicemico);
    }

    @PutMapping("/{idRegistroGlicemico}")
    public ResponseEntity<RegistroGlicemico> atualizar(@PathVariable Long idRegistroGlicemico, @Validated @RequestBody RegistroGlicemico rg) {
        RegistroGlicemico rgSalvo = service.atualizar(idRegistroGlicemico, rg);
        return ResponseEntity.ok(rgSalvo);
    }
}
