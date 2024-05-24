package br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidacaoErro extends ErroCustomizado{
  private final List<CampoErro> campoErros = new ArrayList<CampoErro>();

  public ValidacaoErro(Instant horario, Integer status, String erro, String rota) {
    super(horario, status, erro, rota);
  }
  
  public List<CampoErro> getCampoErros() {
    return campoErros;
  }
  
  public void addErros(String campoNome, String mensagem) {
    campoErros.removeIf(erro -> erro.getNomeCampo().equals(campoNome));
    campoErros.add(new CampoErro(campoNome, mensagem));
  }
}
