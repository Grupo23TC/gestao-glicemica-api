package br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception;

import java.time.Instant;

public class ErroCustomizado {
  private final Instant horario;
  private final Integer status;
  private final String erro;
  private final String rota;

  public ErroCustomizado(Instant horario, Integer status, String erro, String rota) {
    this.horario = horario;
    this.status = status;
    this.erro = erro;
    this.rota = rota;
  }

  public Instant getHorario() {
    return horario;
  }

  public Integer getStatus() {
    return status;
  }

  public String getErro() {
    return erro;
  }

  public String getRota() {
    return rota;
  }
}
