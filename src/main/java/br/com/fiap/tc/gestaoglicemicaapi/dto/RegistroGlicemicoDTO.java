package br.com.fiap.tc.gestaoglicemicaapi.dto;

import java.time.LocalDateTime;

public record RegistroGlicemicoDTO(
        Long id,
        String titulo,
        double valorGlicemia,
        LocalDateTime data,
        String observacao,
        UsuarioDTO usuario
) {
}
