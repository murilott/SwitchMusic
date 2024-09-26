package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeCompleto;

    private String foto;

    @ManyToOne
    private Idioma idioma;

    @Column(nullable = false)
    @ManyToOne
    private Tema tema;

    @Column(nullable = false)
    @OneToOne
    private Usuario usuario;
}
