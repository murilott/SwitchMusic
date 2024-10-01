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
import br.edu.univille.br.relacionamentos.entities.Genero;
import br.edu.univille.br.relacionamentos.entities.Ouvinte;
import br.edu.univille.br.relacionamentos.service.GeneroService;
import br.edu.univille.br.relacionamentos.service.GeneroService;


@RestController
@RequestMapping("switch/genero")
public class GeneroController {
    
    @Autowired
    private GeneroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Genero> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);

        return opt.map(genero -> new ResponseEntity<>(genero, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Genero genero){
        try {
            genero = service.Atualizar(genero);
            return new ResponseEntity<>(genero, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Genero genero){
        try {
            // usuario.setPerfil(new Perfil());
            genero = service.Cadastrar(genero);
            return new ResponseEntity<>(genero, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Genero genero){
        try{
            service.Excluir(genero);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
