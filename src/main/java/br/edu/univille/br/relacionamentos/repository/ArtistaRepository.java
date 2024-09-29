package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    
}
