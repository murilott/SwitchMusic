package br.edu.univille.br.relacionamentos.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class Ouvinte extends Pessoa{
    // @Column(nullable = false)
    // @OneToOne
    // private Perfil perfil;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToMany
    @JoinColumn(name = "ouvinte_id")
    private Playlist curtidos;

    @OneToMany
    @JoinColumn(name = "ouvinte_id")
    private List<Artista> seguindo;
}
