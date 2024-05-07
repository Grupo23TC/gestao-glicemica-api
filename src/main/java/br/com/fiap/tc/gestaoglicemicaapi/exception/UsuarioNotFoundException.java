package br.com.fiap.tc.gestaoglicemicaapi.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Usuário não encontrado com ID: " + id);
    }
}