package br.com.fiap.tc.gestaoglicemicaapi.dto;

public record RegistroGlicemicoMinDTO(
    Long id,
    String titulo,
    double valorGlicemia,
    String observacao,
    Long usuarioId
) {
}
