package br.edu.univille.br.relacionamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Lista;
import br.edu.univille.br.relacionamentos.entities.Musica;
import br.edu.univille.br.relacionamentos.repository.ListaRepository;

@Service
public class ListaService {
    
    @Autowired
    ListaRepository repository;

    // public List<Lista> ObterTodosDoUsuario(Usuario usuario) {
    //     List<Lista> todos = new ArrayList<Lista>();

    //     for( var lista : repository.findAll()) {
    //         if (lista.getCriador().getId() == usuario.getId()) {
    //             todos.add(lista);
    //         }
    //     }

    //     return todos;
    // }

    public Lista ObterPeloId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void IncluirMusica(Lista lista, Musica musica) {
        lista.getMusicas().add(musica);
    }

    public Lista Atualizar(Lista lista) {
        Lista antigo = repository.findById(lista.getId()).orElse(null);

        antigo.setNome(lista.getNome());
        antigo.setCriador(lista.getCriador());
        // antigo.setCurtidas(lista.getCurtidas());
        antigo.setMusicas(lista.getMusicas());

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
