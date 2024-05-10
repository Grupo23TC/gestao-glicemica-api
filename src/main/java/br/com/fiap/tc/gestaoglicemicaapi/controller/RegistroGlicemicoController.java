package br.com.fiap.tc.gestaoglicemicaapi.controller;

import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoDTO;
import br.com.fiap.tc.gestaoglicemicaapi.dto.RegistroGlicemicoMinDTO;
import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import br.com.fiap.tc.gestaoglicemicaapi.service.RegistroGlicemicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/listaRg")
    public ResponseEntity<Page<RegistroGlicemico>> listarEventos(
        @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {
        Page<RegistroGlicemico> rg = service.listarEventos(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(rg);
    }

    @GetMapping("/{idRegistroGlicemico}")
    public ResponseEntity<RegistroGlicemicoDTO> buscarPeloId(@PathVariable Long idRegistroGlicemico)  {
        RegistroGlicemicoDTO rg = service.buscarPeloId(idRegistroGlicemico);
        return ResponseEntity.ok(rg);
    }

    @PostMapping
    public ResponseEntity<RegistroGlicemicoDTO> criar(@Validated @RequestBody RegistroGlicemicoMinDTO rg) {
        RegistroGlicemicoDTO rgSalvo = service.criar(rg);
        return ResponseEntity.status(HttpStatus.CREATED).body(rgSalvo);
    }

    @DeleteMapping("/{idRegistroGlicemico}")
    public ResponseEntity<Void> deletar(@PathVariable Long idRegistroGlicemico) {
        service.deletar(idRegistroGlicemico);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idRegistroGlicemico}")
    public ResponseEntity<RegistroGlicemicoDTO> atualizar(@PathVariable Long idRegistroGlicemico, @Validated @RequestBody RegistroGlicemico rg) {
        RegistroGlicemicoDTO rgSalvo = service.atualizar(idRegistroGlicemico, rg);
        return ResponseEntity.ok(rgSalvo);
    }
}
