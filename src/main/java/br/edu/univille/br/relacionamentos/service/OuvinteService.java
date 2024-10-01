package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Artista;
import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.entities.Ouvinte;
import br.edu.univille.br.relacionamentos.repository.OuvinteRepository;

@Service
public class OuvinteService extends PessoaService {
    
    @Autowired
    private OuvinteRepository repository;

    

    // public Optional<Ouvinte> ObterPeloId(Long id) {
    //     Optional<Ouvinte> user = repository.findById(id);
    //     user.ifPresent(us -> us.setSenha("*"));
    //     // user.setSenha("*");
    //     return user;
    // }

    public void Curtir(Ouvinte ouvinte, Musica musica) {
        for ( var mus : ouvinte.getCurtidos().getMusicas() ) {
            if ( musica == mus ) {
                ouvinte.getCurtidos().getMusicas().remove(musica);
            } else {
                ouvinte.getCurtidos().getMusicas().add(musica);
            }
        }
        
    }

    public void Seguir(Ouvinte ouvinte, Artista artista) {
        for ( var art : ouvinte.getSeguindo() ) {
            if ( artista == art ) {
                ouvinte.getSeguindo().remove(artista);
            } else {
                ouvinte.getSeguindo().add(artista);
            }
        }
    }

    

    public Ouvinte Cadastrar(Ouvinte ouvinte) {
        // Perfil perfil = new Perfil();

        ouvinte.setId(0);
        ouvinte = repository.save(ouvinte);

        return ouvinte;
    }

    public Ouvinte Atualizar(Ouvinte ouvinte) {
        Ouvinte antigo = repository.findById(ouvinte.getId()).orElse(null);
        
        antigo.setPerfil(ouvinte.getPerfil());
        antigo.setNome(ouvinte.getNome());
        antigo.setEmail(ouvinte.getEmail());
        antigo.setSeguindo(ouvinte.getSeguindo());
        // antigo.setCurtidos(ouvinte.getCurtidos());
        // antigo.setVerificado(ouvinte.isVerificado());

        return repository.save(antigo);
    }

    public void Excluir(Ouvinte ouvinte) {
        var antigo = repository.findById(ouvinte.getId()).orElse(null);

        repository.delete(antigo);
    } 

}
