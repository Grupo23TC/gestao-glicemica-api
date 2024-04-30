package br.com.fiap.tc.gestaoglicemicaapi.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CategoriaDiabeteEnum {

    PRE_DIABETES(1, "Pre Diabetes"),
    DIABETE_I(2, "Diabete I"),
    DIABETE_II(3, "Diabete II"),
    DIABETE_GESTACIONAL(4, "Diabete Gestacional");

    private final long id;
    private final String nome;
}
