package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;

import java.time.LocalDate;

public interface RelatorioService {
  Relatorio montaRelatorio(Long usuarioId, LocalDate dataIni, LocalDate dataFim);
}
