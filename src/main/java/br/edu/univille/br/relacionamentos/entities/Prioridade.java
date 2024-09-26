package br.edu.univille.br.relacionamentos.entities;

public enum Prioridade {
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta");

    private String nome;

    Prioridade(String nome){
        this.nome = nome;
    }

    public String getnome(){
        return this.nome;
    }
}
