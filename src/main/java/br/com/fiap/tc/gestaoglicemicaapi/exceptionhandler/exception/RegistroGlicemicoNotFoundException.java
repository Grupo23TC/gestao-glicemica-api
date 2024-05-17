package br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception;

public class RegistroGlicemicoNotFoundException extends RuntimeException {
  public RegistroGlicemicoNotFoundException(Long id) {
    super("Registro Glicemico de ID: " + id + " não encontrado");
  }
}
