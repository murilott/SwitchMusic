package br.edu.univille.br.relacionamentos.controller;

import br.edu.univille.br.relacionamentos.entities.Lista;
import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.univille.br.relacionamentos.entities.Tarefa;
import br.edu.univille.br.relacionamentos.service.ListaService;

import java.util.List;


@RestController()
@RequestMapping("api/lista")
public class ListaController {
    
    @Autowired
    private ListaService service;

    @GetMapping()
    public List<Lista> obterTodosdoUsuario(@RequestBody Usuario usuario) {
        return service.ObterTodosDoUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);
        
        return opt.map(lista -> new ResponseEntity<>(lista, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Lista lista){
        try {
            lista = service.Atualizar(lista);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Lista lista){
        try {
            // usuario.setPerfil(new Perfil());
            lista = service.Cadastrar(lista);
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Lista lista){
        try{
            service.Excluir(lista);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
