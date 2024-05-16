package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;
import br.com.fiap.tc.gestaoglicemicaapi.utils.RegraStatusGlicemico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RelatorioServiceImpl implements RelatorioService{

  @Autowired
  private RegistroGlicemicoService rgService;


  public Relatorio montaRelatorio(Long usuarioId, LocalDate dataIni, LocalDate dataFim) {
    List<RegistroGlicemico> registros = rgService.registrosDoUsuario(usuarioId, dataIni, dataFim);

    double valorMedio = mediaRegistrosGlicemicos(registros);

    Relatorio relatorio = new Relatorio();

    //TODO ver como atrelar o StatusGlicemico ao valorMédio
    relatorio.setMediaValorGlicemia(valorMedio);
    relatorio.setStatusGlicemia(RegraStatusGlicemico.calculaResultadoGlicemia(valorMedio));
    relatorio.setMaiorValorGlicemia(maiorValorGlicemico(registros));
    relatorio.setMenorValorGlicemia(menorValorGlicemico(registros));
    relatorio.setDataIni(dataIni);
    relatorio.setDataFim(dataFim);
    relatorio.setListaDeRegistros(registros);

    return relatorio;
  }

  private double maiorValorGlicemico(List<RegistroGlicemico> registroGlicemicos) {
    return registroGlicemicos.stream()
            .mapToDouble(RegistroGlicemico::getValorGlicemia)
            .max()
            .orElseThrow(NoSuchElementException::new);
  }

  private double menorValorGlicemico(List<RegistroGlicemico> registroGlicemicos) {
    return registroGlicemicos.stream()
            .mapToDouble(RegistroGlicemico::getValorGlicemia)
            .min()
            .orElseThrow(NoSuchElementException::new);
  }

  private double mediaRegistrosGlicemicos(List<RegistroGlicemico> registroGlicemicos){
    return registroGlicemicos.stream()
            .mapToDouble(RegistroGlicemico::getValorGlicemia)
            .average()
            .orElseThrow(NoSuchElementException::new);
  }
}
