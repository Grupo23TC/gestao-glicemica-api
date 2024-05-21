package br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler;

import br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.dto.ErrorDTO;
import br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception.RegistroGlicemicoNotFoundException;
import br.com.fiap.tc.gestaoglicemicaapi.exceptionhandler.exception.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(RegistroGlicemicoNotFoundException.class)
    public ErrorDTO handleRegistroGlicemicoNotFoundException(RegistroGlicemicoNotFoundException ex){
        return new ErrorDTO(
                ex.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(UsuarioNotFoundException.class)
    public ErrorDTO handleUsuarioNotFoundException(UsuarioNotFoundException ex){
        return new ErrorDTO(
                ex.getMessage()
        );
    }


}
