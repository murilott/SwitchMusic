package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.ManyToOne;

import java.util.List;

public class Compartilhamento {
    private long id;

    @ManyToOne
    private Acesso acesso;
    @ManyToOne
    private Usuario compartilhadoPor;
    @ManyToOne
    private Usuario recebidoPor;


    private Lista listaDeTarefas;
}
