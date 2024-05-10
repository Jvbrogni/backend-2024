package com.exerciciojoao.exercicio.model;

import java.io.Serializable;

public class Indicacao implements Serializable {

    private Indicavel indicavel;
    private String categoria;

    public Indicacao(Indicavel indicavel, String categoria) {
        this.categoria = categoria;
        this.indicavel = indicavel;
    }

    public Indicavel getIndicavel() {
        return this.indicavel;
    }

    public boolean getElegibilidadeIndicavel() {
        return this.indicavel.elegivel();
    }
}