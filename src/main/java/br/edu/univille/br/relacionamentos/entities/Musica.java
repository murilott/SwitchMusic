package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(nullable = false)
    @ManyToOne
    private Album album;
    private int duracao;
    private long reproducoes;
    private boolean explicito;

    @OneToOne
    private Genero genero;
}
