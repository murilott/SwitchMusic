package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.ManyToOne;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Compartilhamento {
    private long id;

    // @ManyToOne
    // private Acesso acesso;
    @ManyToOne
    private Ouvinte compartilhadoPor;
    @ManyToOne
    private Ouvinte recebidoPor;


    private Lista listaDeTarefas;
}
