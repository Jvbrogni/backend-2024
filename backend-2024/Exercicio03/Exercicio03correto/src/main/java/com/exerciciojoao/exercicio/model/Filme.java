package com.exerciciojoao.exercicio.model;

import java.io.Serializable;

public class Filme implements Indicavel, Serializable {

    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Filme(String nome, String genero, boolean elegivel) {
        this.nome = nome;
        this.genero = genero;
        this.elegivel = elegivel;
    }

    @Override
    public boolean elegivel() {
        return elegivel;
    }

    @Override
    public short numeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }
}
