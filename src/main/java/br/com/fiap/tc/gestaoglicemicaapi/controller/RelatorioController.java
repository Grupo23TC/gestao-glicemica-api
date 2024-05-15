package br.com.fiap.tc.gestaoglicemicaapi.controller;

import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;
import br.com.fiap.tc.gestaoglicemicaapi.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/relatorio")
public class RelatorioController {

  @Autowired
  private RelatorioService service;

  @GetMapping("/geraRelatorio/{idUsuario}")
  public ResponseEntity<Relatorio> gerarRelatorio(@PathVariable Long idUsuario, @RequestParam LocalDate dataIni, @RequestParam LocalDate dataFim) {

    Relatorio relatorio = service.montaRelatorio(idUsuario, dataIni, dataFim);

    return ResponseEntity.status(HttpStatus.OK).body(relatorio);
  }
}

