package br.com.fiap.tc.gestaoglicemicaapi.model;

import br.com.fiap.tc.gestaoglicemicaapi.enums.CategoriaDiabeteEnum;
import br.com.fiap.tc.gestaoglicemicaapi.enums.SexoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private SexoEnum sexo;

    private int idade;

    private CategoriaDiabeteEnum categoriaDiabete;

//    @OneToMany(mappedBy = "usuario")
//    private List<RegistroGlicemico> registrosGlicemicos;
}
