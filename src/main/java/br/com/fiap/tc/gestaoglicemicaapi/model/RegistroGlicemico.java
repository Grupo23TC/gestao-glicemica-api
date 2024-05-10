package br.com.fiap.tc.gestaoglicemicaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class RegistroGlicemico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String titulo;

    @NonNull
    private double valorGlicemia;

    @NonNull
    private String observacao;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("hibernateLazyInitializer")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // Chave estrangeira

}
