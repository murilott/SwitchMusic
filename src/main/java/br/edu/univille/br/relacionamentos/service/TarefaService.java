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
import br.edu.univille.br.relacionamentos.repository.TarefaRepository;
import br.edu.univille.br.relacionamentos.repository.UsuarioRepository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class TarefaService {
    
    @Autowired
    TarefaRepository repository;

    @Autowired
    ListaRepository listaRepository;

    public Lista ObterTodosDaLista(Long id) {
        Lista todosLista = listaRepository.findById(id).orElse(null);

        
        
        // List<Lista> todosLista = listaRepository.findAll();
        // for ( var lis : listaRepository.findAll()){
        //     for ( Tarefa tar : lis.getTarefas()) {
        //         if (tarefa.getId() == tar.getId()) {

        //         }
        //     }
        // }

        return todosLista;
    }

    public Optional<Tarefa> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Tarefa Atualizar(Tarefa tarefa) {
        Tarefa antigo = repository.findById(tarefa.getId()).orElse(null);

        antigo.setTitulo(tarefa.getTitulo());
        antigo.setDescricao(tarefa.getDescricao());
        antigo.setPrioridade(tarefa.getPrioridade());
        antigo.setStatus(tarefa.getStatus());

        return repository.save(antigo);
    }

    public Tarefa Cadastrar(Tarefa tarefa) {
        tarefa.setId(0);
        tarefa = repository.save(tarefa);

        return tarefa;
    }
}
