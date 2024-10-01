package br.edu.univille.br.relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Ouvinte;
import br.edu.univille.br.relacionamentos.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository repository;

    public Perfil Obter(Ouvinte ouvinte) {
        return repository.findById(ouvinte.getPerfil().getId()).orElse(null);
    }

    public Perfil Atualizar(Perfil perfil) {
        Perfil antigo = repository.findById(perfil.getId()).orElse(null);
        
        // antigo.setPessoa(perfil.getPessoa());
        antigo.setPreferencias(perfil.getPreferencias());

        return repository.save(antigo);
    }
    
}
