package br.com.satc.exercicio4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {

    @Autowired
    private JogadorGerador jogadorGerador;

    @GetMapping("/gerar-jogador")
    public String gerarJogador() {
        Jogador jogador = jogadorGerador.geraJogador();
        return jogador.getDescricao();
    }
}
