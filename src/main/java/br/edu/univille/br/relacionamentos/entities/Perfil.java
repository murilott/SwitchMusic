package br.edu.univille.br.relacionamentos.entities;

import java.util.List;

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

    @ManyToOne
    private List<Genero> preferencias;

    @Column(nullable = false)
    @OneToOne
    private Pessoa pessoa;
}
