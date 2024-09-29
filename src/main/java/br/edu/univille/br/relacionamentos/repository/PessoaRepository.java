package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
