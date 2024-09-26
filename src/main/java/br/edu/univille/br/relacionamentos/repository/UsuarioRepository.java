package br.edu.univille.br.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.br.relacionamentos.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
