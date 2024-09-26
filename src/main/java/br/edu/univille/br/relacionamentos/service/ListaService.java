package br.edu.univille.br.relacionamentos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Lista;
import br.edu.univille.br.relacionamentos.entities.Perfil;
import br.edu.univille.br.relacionamentos.entities.Tarefa;
import br.edu.univille.br.relacionamentos.entities.Usuario;
import br.edu.univille.br.relacionamentos.repository.ListaRepository;
import br.edu.univille.br.relacionamentos.repository.PerfilRepository;
import br.edu.univille.br.relacionamentos.repository.UsuarioRepository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class ListaService {
    
    @Autowired
    ListaRepository repository;

    public List<Lista> ObterTodosDoUsuario(Usuario usuario) {
        List<Lista> todos = new ArrayList<Lista>();

        for( var lista : repository.findAll()) {
            if (lista.getCriador().getId() == usuario.getId()) {
                todos.add(lista);
            }
        }

        return todos;
    }

    public Lista ObterPeloId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Lista Atualizar(Lista lista) {
        Lista antigo = repository.findById(lista.getId()).orElse(null);

        antigo.setTarefas(lista.getTarefas());
        antigo.setNome(lista.getNome());
        // antigo.setCriador(lista.getCriador());
        antigo.setCor(lista.getCor());

        return repository.save(antigo);
    }

    public Lista Cadastrar(Lista lista) {
        lista.setId(0);
        lista = repository.save(lista);

        return lista;
    }

    public void Excluir(Lista lista) {
        var antigo = repository.findById(lista.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
