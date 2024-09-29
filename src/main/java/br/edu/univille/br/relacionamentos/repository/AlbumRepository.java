package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
    
}
