package br.edu.univille.br.relacionamentos.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class Album extends Lista{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
