package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Lista;

public interface ListaRepository extends JpaRepository<Lista, Long>{
    
}
