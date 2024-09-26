package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
