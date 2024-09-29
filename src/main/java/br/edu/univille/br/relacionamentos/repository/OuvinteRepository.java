package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Ouvinte;

public interface OuvinteRepository extends JpaRepository<Ouvinte, Long>{
    
}
