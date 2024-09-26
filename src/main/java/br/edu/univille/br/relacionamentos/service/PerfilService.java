package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.repository.PerfilRepository;
import br.edu.univille.br.relacionamentos.repository.UsuarioRepository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository repository;

    public Perfil Obter(Usuario usuario) {
        return repository.findById(usuario.getPerfil().getId()).orElse(null);
    }

    public Perfil Atualizar(Perfil perfil) {
        Perfil antigo = repository.findById(perfil.getId()).orElse(null);
        
        antigo.setNomeCompleto(perfil.getNomeCompleto());
        antigo.setFoto(perfil.getFoto());
        antigo.setIdioma(perfil.getIdioma());
        antigo.setTema(perfil.getTema());

        return repository.save(antigo);
    }
    
}
