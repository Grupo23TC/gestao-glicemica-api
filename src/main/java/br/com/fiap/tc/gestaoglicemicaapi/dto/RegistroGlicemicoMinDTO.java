package br.com.fiap.tc.gestaoglicemicaapi.dto;

import java.time.LocalDateTime;

public record RegistroGlicemicoMinDTO(
    Long id,
    String titulo,
    double valorGlicemia,
    LocalDateTime data,
    String observacao,
    Long usuarioId
) {
}
