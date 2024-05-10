package satc.exercicio6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Instagram")
public class PostagemController {

    // Validação e criação de postagem
    @PostMapping("/postagem")
    public ResponseEntity<String> criarPostagem(@RequestBody Postagem postagem) {
        if (postagem.getConteudo() == null || postagem.getImagem() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados mal formatados");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Postagem criada com sucesso");
    }

    // Busca de postagem
    @GetMapping("/postagem/{postagemId}")
    public ResponseEntity<Optional<Object>> obterPostagem(@PathVariable String postagemId) {
        if ("654789".equals(postagemId)) {
            return ResponseEntity.ok(new Postagem(postagemId, "Mais uma aula na satc.", "https://example.com/path.imagem.png", 45));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
    }

    // Atualização de postagem
    @PutMapping("/postagem/{postagemId}")
    public ResponseEntity<String> atualizarPostagem(@PathVariable String postagemId, @RequestBody Postagem postagem) {

        if (!"654789".equals(postagemId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Postagem não encontrada");
        }
        if (postagem.getUsuarioId() != "userIdPermitido") { // Supõe-se que existe um ID de usuário que tem permissão
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você não possui permissão para atualizar esta postagem");
        }
        return ResponseEntity.ok("Postagem atualizada com sucesso");
    }

    // Simulação de exclusão de postagem
    @DeleteMapping("/delete/{postagemId}")
    public ResponseEntity<String> excluirPostagem(@PathVariable String postagemId) {
        if (!"654789".equals(postagemId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Postagem não encontrada");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
