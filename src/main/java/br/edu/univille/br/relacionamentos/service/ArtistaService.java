package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Artista;
import br.edu.univille.br.relacionamentos.repository.AlbumRepository;
import br.edu.univille.br.relacionamentos.repository.ArtistaRepository;

@Service
public class ArtistaService  extends PessoaService{
    
    @Autowired
    ArtistaRepository repository;

    @Autowired
    AlbumRepository albumRepository;

    // public Optional<Artista> ObterPeloId(Long id) {
    //     return repository.findById(id); //.orElse(null)
    // }

    // Já tem atributo discografia
    // public List<Album> ObterAlbuns(Artista artista) {
    //     List<Album> todos = new ArrayList<Album>();

    //     for( var album : albumRepository.findAll()) {
    //         if (album.getCriador() == artista) {
    //             todos.add(album);
    //         }
    //     }

    //     return todos;
    // }

    public Long ObterTotalReproducoes(Artista artista){
        // List<Album> todos = ObterAlbuns(artista);
        long total = 0;

        for ( var alb : artista.getDiscografia() ) {
            for ( var mus : alb.getMusicas() ) {
                total += mus.getReproducoes();
            }
        }

        return total;
    }

    public Artista Cadastrar(Artista artista) {
        artista.setId(0);
        artista = repository.save(artista);

        return artista;
    }

    public Artista Atualizar(Artista artista) {
        Artista antigo = repository.findById(artista.getId()).orElse(null);

        antigo.setDiscografia(artista.getDiscografia());
        antigo.setOuvintes(artista.getOuvintes());

        antigo.setSenha(artista.getSenha());
        antigo.setNome(artista.getNome());
        antigo.setEmail(artista.getEmail());
        antigo.setVerificado(artista.isVerificado());
        antigo.setPerfil(artista.getPerfil());

        return repository.save(antigo);
    }

    public void Excluir(Artista artista) {
        var antigo = repository.findById(artista.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
