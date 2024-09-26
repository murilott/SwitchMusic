package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.repository.UsuarioRepository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public Optional<Usuario> ObterPeloId(Long id) {
        Optional<Usuario> user = repository.findById(id);
        user.ifPresent(us -> us.setSenha("*"));
        // user.setSenha("*");
        return user;
    }

    public Usuario Cadastrar(Usuario usuario) {
        Perfil perfil = new Perfil();
        perfil.setNomeCompleto(usuario.getNomeCompleto());
        perfil.setUsuario(usuario);

        usuario.setId(0);
        usuario.setPerfil(perfil);
        usuario = repository.save(usuario);

        return usuario;
    }

    public Usuario Atualizar(Usuario usuario) {
        Usuario antigo = repository.findById(usuario.getId()).orElse(null);
        
        antigo.setNomeCompleto(usuario.getNomeCompleto());
        antigo.setNomeUser(usuario.getNomeUser());
        antigo.setEmail(usuario.getEmail());
        antigo.setListas(usuario.getListas());
        antigo.setPerfil(usuario.getPerfil());

        return repository.save(antigo);
    }

}
