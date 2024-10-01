package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.repository.MusicaRepository;

@Service
public class MusicaService {
    
    @Autowired
    MusicaRepository repository;

    public Optional<Musica> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Musica Cadastrar(Musica musica) {
        musica.setId(0);
        musica = repository.save(musica);

        return musica;
    }

    public Musica Atualizar(Musica musica) {
        Musica antigo = repository.findById(musica.getId()).orElse(null);

        antigo.setAlbum(musica.getAlbum());
        antigo.setNome(musica.getNome());
        antigo.setDuracao(musica.getDuracao());
        antigo.setExplicito(musica.isExplicito());
        antigo.setReproducoes(musica.getReproducoes());
        antigo.setGenero(musica.getGenero());

        return repository.save(antigo);
    }

    public void Excluir(Musica musica) {
        var antigo = repository.findById(musica.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
