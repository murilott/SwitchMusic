package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Musica {

    private String nome;
    private Album album;
    private String duracao;
    private Long reproducoes;
    private boolean explicito;
}


//Musica: String nome, Album album, String duracao, Long reproducoes, boolean explicito, boolean like
//
//Artista: String nome, Long ouvintes, boolean verificado, List<Album> discografia
//
//        Lista
//
//Album
//
//        Playlist
//
//Queue
//
//Usuario: String nome, String email, String senha, boolean verificado, List<Album> curtidos, List<> List<Artista> seguindo
//
//        Perfil