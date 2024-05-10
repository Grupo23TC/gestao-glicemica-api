package br.com.fiap.tc.gestaoglicemicaapi.dto;

import br.com.fiap.tc.gestaoglicemicaapi.enums.CategoriaDiabeteEnum;
import br.com.fiap.tc.gestaoglicemicaapi.enums.SexoEnum;

public record UsuarioDTO(
        String nome,
        SexoEnum sexo,
        int idade,
        CategoriaDiabeteEnum categoriaDiabeteEnum
) {
}
