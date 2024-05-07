package br.com.fiap.tc.gestaoglicemicaapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
