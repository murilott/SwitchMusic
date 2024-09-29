package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Queue;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    
}
