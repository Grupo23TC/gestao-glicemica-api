package br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception;

public class CampoErro {
  private final String nomeCampo;
  private final String mensagem;
  
  public CampoErro(String nomeCampo, String mensagem) {
    this.nomeCampo = nomeCampo;
    this.mensagem = mensagem;
  }
  
  public String getNomeCampo() {
    return nomeCampo;
  }
  
  public String getMensagem() {
    return mensagem;
  }
}
