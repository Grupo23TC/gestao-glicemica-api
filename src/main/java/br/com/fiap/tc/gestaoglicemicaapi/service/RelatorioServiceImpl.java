package br.com.fiap.tc.gestaoglicemicaapi.service;

import br.com.fiap.tc.gestaoglicemicaapi.model.RegistroGlicemico;
import br.com.fiap.tc.gestaoglicemicaapi.model.Relatorio;
import br.com.fiap.tc.gestaoglicemicaapi.utils.RegraStatusGlicemico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    relatorio.setDataIni(dataIni);
    relatorio.setDataFim(dataFim);
    relatorio.setListaDeRegistros(registros);

    return relatorio;
  }

  private double mediaRegistrosGlicemicos(List<RegistroGlicemico> registros){
    List<RegistroGlicemico> listaDeRegistros = registros;

    double totalValorGlicemia = 0.0;
    int countRegistros = 0;

    for (RegistroGlicemico registroGlicemico : listaDeRegistros) {
      double valorGlicemia = registroGlicemico.getValorGlicemia();

      totalValorGlicemia += valorGlicemia;
      countRegistros++;
    }

    double mediaValorGlicemia = totalValorGlicemia / countRegistros;
    return mediaValorGlicemia;
  }
}
