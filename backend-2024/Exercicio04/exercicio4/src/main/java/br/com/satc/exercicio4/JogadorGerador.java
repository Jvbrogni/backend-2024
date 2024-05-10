package br.com.satc.exercicio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class JogadorGerador {
    private final WebClient webClient;
    private List<String> nomes;
    private List<String> sobrenomes;
    private List<String> posicoes;
    private List<String> clubes;

    @Autowired
    public JogadorGerador(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @PostConstruct
    public void init() {
        nomes = carregaLista("https://venson.net.br/resources/data/nomes.txt").block();
        sobrenomes = carregaLista("https://venson.net.br/resources/data/sobrenomes.txt").block();
        posicoes = carregaLista("https://venson.net.br/resources/data/posicoes.txt").block();
        clubes = carregaLista("https://venson.net.br/resources/data/clubes.txt").block();
    }

    private Mono<List<String>> carregaLista(String uri) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> body.replace("\"", "")
                        .replace(",", "")
                        .replace("-", " ")
                        .split("\n"))
                .map(Arrays::asList);
    }
    public Jogador geraJogador() {
        Random rand = new Random();
        String nome = nomes.get(rand.nextInt(nomes.size()));
        String sobrenome = sobrenomes.get(rand.nextInt(sobrenomes.size()));
        String posicao = posicoes.get(rand.nextInt(posicoes.size()));
        String clube = clubes.get(rand.nextInt(clubes.size()));
        int idade = 17 + rand.nextInt(23);

        return new Jogador(nome, sobrenome, posicao, idade, clube);
    }
}





