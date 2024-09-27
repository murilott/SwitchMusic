package br.edu.univille.br.relacionamentos.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario extends Pessoa{
    @Column(nullable = false)
    @OneToOne
    private Perfil perfil;
    
    private List<Album> curtidos;
    private List<Artista> seguindo;
}
