package org.example;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador.carregarDados();

        List<Jogador> jogadores = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            jogadores.add(JogadorGerador.criarJogador());
        }

        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getDescricao());
        }
    }
}