package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;

import java.time.LocalDateTime;

public interface RelatorioService {
  Relatorio montaRelatorio(Long usuarioId, LocalDateTime dataIni, LocalDateTime dataFim);
}
