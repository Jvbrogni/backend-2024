package com.exerciciojoao.exercicio.dto;

import com.exerciciojoao.exercicio.model.Ator;
import com.exerciciojoao.exercicio.model.Filme;

public class IndicacaoFilmeDto {

    private Filme indicavel;
    private String categoria;

    public boolean getElegibilidadeIndicavel() {
        return this.indicavel.elegivel();
    }

    public Filme getIndicavel() {
        return this.indicavel;
    }

    public String getCategoria() {
        return this.categoria;
    }
}