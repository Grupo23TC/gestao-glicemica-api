package br.com.fiap.tc.gestaoglicemicaapi.dto;

import br.com.fiap.tc.gestaoglicemicaapi.enums.CategoriaDiabeteEnum;
import br.com.fiap.tc.gestaoglicemicaapi.enums.SexoEnum;

public record UsuarioDTO(
        Long id,
        String nome,
        SexoEnum sexo,
        int idade,
        CategoriaDiabeteEnum categoriaDiabeteEnum
) {
}
