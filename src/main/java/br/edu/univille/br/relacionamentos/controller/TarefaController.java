package br.edu.univille.br.relacionamentos.controller;

import br.edu.univille.br.relacionamentos.entities.Lista;
import br.edu.univille.br.relacionamentos.entities.Tarefa;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping()
    public List<Tarefa> ObterTodosDaLista(@RequestBody Tarefa tarefa) {
        return service.ObterTodosDoUsuario(tarefa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> obterPeloId(@PathVariable Long id){
        var opt = service.ObterPeloId(id);

        return opt.map(lista -> new ResponseEntity<>(lista, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
