package br.com.satc.exercicio4;

public class Jogador {
    private final String nome;
    private final String sobrenome;
    private final String posicao;
    private final int idade;
    private final String clube;

    public Jogador(String nome, String sobrenome, String posicao, int idade, String clube) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.idade = idade;
        this.clube = clube;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getIdade() {
        return idade;
    }

    public String getClube() {
        return clube;
    }

    public String getDescricao() {
        return String.format("%s %s é um futebolista brasileiro de %s anos que atua como %s. Atualmente defende o %s.",
                getNome(), getSobrenome(), getIdade(), getPosicao(), getClube());
    }
}
