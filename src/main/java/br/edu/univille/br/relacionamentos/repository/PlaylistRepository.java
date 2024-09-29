package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    
}
