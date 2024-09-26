package br.edu.univille.br.relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.service.PerfilService;


@RestController
@RequestMapping("api/perfil")
public class PerfilController {
    
    @Autowired
    private PerfilService service;

    @GetMapping()
    public Perfil obter(@RequestBody Usuario usuario) {
        return service.Obter(usuario);
    }

    @PutMapping()
    public ResponseEntity<?> atualizar(@RequestBody Perfil perfil){
        try {
            perfil = service.Atualizar(perfil);
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
