package br.edu.univille.br.relacionamentos.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @ManyToOne
    private Usuario criador;

    @Column(nullable = false)
    private String cor;
    
    @OneToMany
    @JoinColumn(name = "lista_id")
    private List<Tarefa> tarefas;
}
