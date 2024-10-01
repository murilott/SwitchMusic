package br.edu.univille.br.relacionamentos.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Playlist;
import br.edu.univille.br.relacionamentos.repository.PlaylistRepository;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository repository;
    
    public Optional<Playlist> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Playlist Cadastrar(Playlist playlist) {
        playlist.setId(0);
        playlist = repository.save(playlist);

        return playlist;
    }

    public Playlist Atualizar(Playlist playlist) {
        Playlist antigo = repository.findById(playlist.getId()).orElse(null);

        antigo.setCriador(playlist.getCriador());
        antigo.setNome(playlist.getNome());
        antigo.setCurtidas(playlist.getCurtidas());
        antigo.setMusicas(playlist.getMusicas());

        return repository.save(antigo);
    }

    public void Excluir(Playlist playlist) {
        var antigo = repository.findById(playlist.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
