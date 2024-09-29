package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
    
}
