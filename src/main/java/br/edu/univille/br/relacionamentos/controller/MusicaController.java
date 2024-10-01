package br.edu.univille.br.relacionamentos.controller;

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

import br.edu.univille.br.relacionamentos.entities.Lista;
import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.entities.Ouvinte;
import br.edu.univille.br.relacionamentos.service.MusicaService;


@RestController
@RequestMapping("switch/musica")
public class MusicaController {
    
    @Autowired
    private MusicaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Musica> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);

        return opt.map(musica -> new ResponseEntity<>(musica, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Musica musica){
        try {
            musica = service.Atualizar(musica);
            return new ResponseEntity<>(musica, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Musica musica){
        try {
            // usuario.setPerfil(new Perfil());
            musica = service.Cadastrar(musica);
            return new ResponseEntity<>(musica, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Musica musica){
        try{
            service.Excluir(musica);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
