package br.edu.univille.br.relacionamentos.entities;



public enum Status {
    PENDENTE("Pendente"),
    EM_PROGRESSO("Em Progresso"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private String nome;

    Status(String nome){
        this.nome = nome;
    }

    public String getnome(){
        return this.nome;
    }
}
