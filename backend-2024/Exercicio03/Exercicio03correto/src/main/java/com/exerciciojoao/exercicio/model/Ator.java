package com.exerciciojoao.exercicio.model;

import java.io.Serializable;

public class Ator implements Indicavel, Serializable {

    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Ator(String nome, String nacionalidade, boolean elegivel) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
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
