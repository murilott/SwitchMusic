package br.edu.univille.br.relacionamentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.entities.Artista;
import br.edu.univille.br.relacionamentos.entities.Playlist;
import br.edu.univille.br.relacionamentos.service.ArtistaService;


@RestController
@RequestMapping("switch/artista")
public class ArtistaController {
    
    @Autowired
    private ArtistaService service;

    @GetMapping("/{id}")
    public Artista obterPeloId(@PathVariable Long id){
        Artista opt = (Artista) service.ObterPeloId(id).orElse(null);
        // (Artista) 
        // .orElse(null);
        return opt;
    };

    @GetMapping()
    public ResponseEntity<?> verificar(@RequestBody Artista artista){
        try {
            service.Verificar(artista);
            return new ResponseEntity<>(artista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/playlist")
    public ResponseEntity<?> criarPlaylist(@RequestBody Artista artista, List<Musica> musicas, String nome){
        try {
            var playlist = service.CriarPlaylist(artista, musicas, nome);
            return new ResponseEntity<>(playlist, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/playlist")
    public ResponseEntity<?> obterPlaylists(@RequestBody Artista artista){
        try {
            List<Playlist> playlists = service.ObterPlaylists(artista);
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Artista artista){
        try {
            artista = service.Atualizar(artista);
            return new ResponseEntity<>(artista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Artista artista){
        try {
            // usuario.setPerfil(new Perfil());
            artista = service.Cadastrar(artista);
            return new ResponseEntity<>(artista, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Artista artista){
        try{
            service.Excluir(artista);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
