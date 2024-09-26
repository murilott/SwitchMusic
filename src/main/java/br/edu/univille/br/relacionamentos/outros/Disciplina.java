package br.edu.univille.br.relacionamentos.outros;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Aluno> alunos;

}
