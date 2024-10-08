package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Queue;
import br.edu.univille.br.relacionamentos.repository.QueueRepository;

@Service
public class QueueService {
    
    @Autowired
    QueueRepository repository;
    
    public Optional<Queue> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Queue Cadastrar(Queue queue) {
        queue.setId(0);
        queue = repository.save(queue);

        return queue;
    }

    public Queue Atualizar(Queue queue) {
        Queue antigo = repository.findById(queue.getId()).orElse(null);

        antigo.setCriador(queue.getCriador());
        antigo.setNome(queue.getNome());
        antigo.setCurtidas(queue.getCurtidas());
        antigo.setMusicas(queue.getMusicas());

        return repository.save(antigo);
    }

    public void Excluir(Queue queue) {
        var antigo = repository.findById(queue.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
