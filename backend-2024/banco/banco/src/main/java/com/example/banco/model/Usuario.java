package com.example.banco.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String name;

    @Column
    private String cidade;

    @Column()
    private String email;

    @Column
    private String telefone;

    @Column
    private String senha;
}
