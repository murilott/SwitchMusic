package br.edu.univille.br.relacionamentos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.br.relacionamentos.entities.Genero;
import br.edu.univille.br.relacionamentos.repository.GeneroRepository;

@Service
public class GeneroService {
    
    @Autowired
    GeneroRepository repository;

    public Optional<Genero> ObterPeloId(Long id) {
        return repository.findById(id); //.orElse(null)
    }

    public Genero Cadastrar(Genero genero) {
        genero.setId(0);
        genero = repository.save(genero);

        return genero;
    }

    public Genero Atualizar(Genero genero) {
        Genero antigo = repository.findById(genero.getId()).orElse(null);

        antigo.setNome(genero.getNome());

        return repository.save(antigo);
    }

    public void Excluir(Genero genero) {
        var antigo = repository.findById(genero.getId()).orElse(null);

        repository.delete(antigo);
    } 
}
