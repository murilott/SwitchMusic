package br.edu.univille.br.relacionamentos.controller;

import java.util.List;

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
import br.edu.univille.br.relacionamentos.entities.Pessoa;
import br.edu.univille.br.relacionamentos.entities.Playlist;
import br.edu.univille.br.relacionamentos.service.PessoaService;


@RestController
@RequestMapping("switch/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);

        return opt.map(pessoa -> new ResponseEntity<>(pessoa, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    public ResponseEntity<?> verificar(@RequestBody Pessoa pessoa){
        try {
            service.Verificar(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/playlist")
    public ResponseEntity<?> criarPlaylist(@RequestBody Pessoa pessoa, List<Musica> musicas, String nome){
        try {
            var playlist = service.CriarPlaylist(pessoa, musicas, nome);
            return new ResponseEntity<>(playlist, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/playlist")
    public ResponseEntity<?> obterPlaylists(@RequestBody Pessoa pessoa){
        try {
            List<Playlist> playlists = service.ObterPlaylists(pessoa);
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Pessoa pessoa){
        try {
            pessoa = service.Atualizar(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa){
        try {
            // usuario.setPerfil(new Perfil());
            pessoa = service.Cadastrar(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Pessoa pessoa){
        try{
            service.Excluir(pessoa);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
