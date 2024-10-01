package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Album;
import br.edu.univille.br.relacionamentos.repository.AlbumRepository;


@Service
public class AlbumService {

    @Autowired
    AlbumRepository repository;
    
    public Optional<Album> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Album Cadastrar(Album album) {
        album.setId(0);
        album = repository.save(album);

        return album;
    }

    public Album Atualizar(Album album) {
        Album antigo = repository.findById(album.getId()).orElse(null);

        antigo.setCriador(album.getCriador());
        antigo.setNome(album.getNome());
        antigo.setCurtidas(album.getCurtidas());
        antigo.setMusicas(album.getMusicas());

        return repository.save(antigo);
    }

    public void Excluir(Album album) {
        var antigo = repository.findById(album.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
