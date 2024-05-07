package br.com.fiap.tc.gestaoglicemicaapi.dto;

public record RegistroGlicemicoDTO(
        Long id,
        String titulo,
        double valorGlicemia,
        String observacao,
        UsuarioDTO usuario
) {
}
