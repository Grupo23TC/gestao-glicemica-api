package br.com.fiap.tc.gestaoglicemicaapi.dto;

import java.time.LocalDate;

public record RegistroGlicemicoDTO(
        Long id,
        String titulo,
        double valorGlicemia,
        LocalDate data,
        String observacao,
        UsuarioDTO usuario
) {
}
