package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class JogadorGerador {
    private static String listaDeNomes;
    private static String listaDeSobrenomes;
    private static String listaDePosicoes;
    private static String listaDeClubes;

    public static void carregarDados() throws Exception {
        listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
    }

    private static String retornaListaDaURI(String minhaUri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }

    public static Jogador criarJogador() {
        String nome = retornaIndiceAleatorio(listaDeNomes);
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);
        String posicao = retornaIndiceAleatorio(listaDePosicoes);
        String clube = retornaIndiceAleatorio(listaDeClubes);
        int idade = geraNumeroAleatorio(17, 40);

        return new Jogador(nome, sobrenome, posicao, clube, idade);
    }

    private static int geraNumeroAleatorio(int maior, int menor) {
        int diferenca = maior - menor + 1;
        return (int) (Math.random() * diferenca) + menor;
    }

    private static String retornaIndiceAleatorio(String stringao) {
        String[] listaDeNomes = stringao.split("\n");
        int indiceAleatorio = (int) (Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }
}
class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private int idade;

    public Jogador(String nome, String sobrenome, String posicao, String clube, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
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

    public String getClube() {
        return clube;
    }

    public int getIdade() {
        return idade;
    }

    public String getDescricao() {
        return nome + " " + sobrenome + " é um futebolista brasileiro de " + idade + " anos que atua como " +
                posicao + " e atualmente defende " + clube;
    }
}

