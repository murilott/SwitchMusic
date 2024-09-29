package br.edu.univille.br.relacionamentos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.entities.Pessoa;
import br.edu.univille.br.relacionamentos.entities.Playlist;
import br.edu.univille.br.relacionamentos.repository.PessoaRepository;
import br.edu.univille.br.relacionamentos.repository.PlaylistRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class PessoaService {
 
    @Autowired
    PessoaRepository repository;

    @Autowired
    PlaylistService playlistService;

    public Optional<Pessoa> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public void CriarPlaylist(Pessoa pessoa, List<Musica> musicas, String nome) {
        Playlist novaPlaylist = new Playlist();

        novaPlaylist.setCriador(pessoa);
        novaPlaylist.setMusicas(musicas);
        novaPlaylist.setNome(nome);
        novaPlaylist.setCurtidas(0);

        novaPlaylist = playlistService.Cadastrar(novaPlaylist);
        
        pessoa.getPlaylists().add(novaPlaylist);
    }

    // pode ser desnecessário
    public List<Playlist> ObterPlaylists(Pessoa pessoa) {
        return pessoa.getPlaylists();
    }

    public void Verificar(Pessoa pessoa) {
        if (pessoa.isVerificado()) {
            pessoa.setVerificado(false);
        } else {
            pessoa.setVerificado(true);
        }
    }

    public Pessoa Cadastrar(Pessoa pessoa) {
        pessoa.setId(0);
        pessoa = repository.save(pessoa);

        return pessoa;
    }

    public Pessoa Atualizar(Pessoa pessoa) {
        Pessoa antigo = repository.findById(pessoa.getId()).orElse(null);

        antigo.setSenha(pessoa.getSenha());
        antigo.setNome(pessoa.getNome());
        antigo.setEmail(pessoa.getEmail());
        antigo.setVerificado(pessoa.isVerificado());
        antigo.setPerfil(pessoa.getPerfil());

        return repository.save(antigo);
    }

    public void Excluir(Pessoa pessoa) {
        var antigo = repository.findById(pessoa.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
