package br.edu.univille.br.relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Tarefa;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.service.ListaService;
import br.edu.univille.br.relacionamentos.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController()
@RequestMapping("api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);
        
        return opt.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
        try {
            usuario = service.Atualizar(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario){
        try {
            // usuario.setPerfil(new Perfil());
            usuario = service.Cadastrar(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    
}