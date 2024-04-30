package br.com.fiap.tc.gestaoglicemicaapi.controller;

import br.com.fiap.tc.gestaoglicemicaapi.enums.StatusGlicemicoEnum;
import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RegistroGlicemicoRepository;
import br.com.fiap.tc.gestaoglicemicaapi.repository.RelatorioRepository;
import br.com.fiap.tc.gestaoglicemicaapi.service.RegistroGlicemicoService;
import br.com.fiap.tc.gestaoglicemicaapi.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/relatorio")
public class RelatorioController {

//    @Autowired
//    private RelatorioRepository relatorioRepository;
//
//    @Autowired
//    private RelatorioService service;

    /*
    @GetMapping("/geraRelatorio/{idUsuario}")
    public ResponseEntity<List<Relatorio>> gerarRelatorio(@PathVariable Long idUsuario, LocalDate dataIni, LocalDate dataFim) {

        // Recuperação dos registros de índice glicêmico do usuário
        List<RegistroGlicemico> registros = recuperarRegistrosGlicemia(idUsuario);

        // Cálculo do status da glicemia com base nos registros
        StatusGlicemicoEnum statusGlicemia = calcularStatusGlicemia(registros);

        // Geração do relatório
        Relatorio relatorio = gerarRelatorio(registros, statusGlicemia);

        //List<Relatorio> relatorio = relatorioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(relatorio);
    }

    */

    /*
        Status Glicemia
        Periodo de tempo do relatorio (dia ini, dia fim)
        dia mais baixo
        dia mais alto
        Valor médio Glicemia
     */

}
