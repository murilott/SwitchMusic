package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    
}
