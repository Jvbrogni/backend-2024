package com.exerciciojoao.exercicio.service;

import com.exerciciojoao.exercicio.dto.IndicacaoAtorDto;
import com.exerciciojoao.exercicio.dto.IndicacaoFilmeDto;
import com.exerciciojoao.exercicio.model.Indicacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OscarService {

    private ArrayList<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacaoAtor(IndicacaoAtorDto indicacaoAtorDto) {
        validaElibilidadeIndicavel(indicacaoAtorDto.getElegibilidadeIndicavel());
        Indicacao indicacao = new Indicacao(indicacaoAtorDto.getIndicavel(), indicacaoAtorDto.getCategoria());
        this.indicacoes.add(indicacao);
    }

    public void adicionarIndicacaoFilme(IndicacaoFilmeDto indicacaoFilmeDto) {
        validaElibilidadeIndicavel(indicacaoFilmeDto.getElegibilidadeIndicavel());
        Indicacao indicacao = new Indicacao(indicacaoFilmeDto.getIndicavel(), indicacaoFilmeDto.getCategoria());
        this.indicacoes.add(indicacao);
    }

    private void validaElibilidadeIndicavel(boolean elegibilidadeIndicavel) {
        if (!elegibilidadeIndicavel) {
            throw new RuntimeException("O indicável não é elegível!");
        }
    }

    public List<Indicacao> mostrarListaIndicados() {
        return this.indicacoes;
    }
}