package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
