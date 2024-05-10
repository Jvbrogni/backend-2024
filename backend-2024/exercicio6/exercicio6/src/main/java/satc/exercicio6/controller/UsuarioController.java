package satc.exercicio6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Instagram")
public class UsuarioController{

    // Validação e criação de usuário
    @PostMapping("/usuario")
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados mal formatados");
        }
        // Simulação de conflito de nome ou email
        if ("albertosilva@gmail.com".equals(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já está em uso");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }

    // Busca de usuário
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<Optional<Object>> obterUsuario(@PathVariable String userId) {
        if ("123".equals(userId)) {
            return ResponseEntity.ok(new Usuario("Alberto da Silva dos Santos", "albertosilva@gmail.com"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
    }

    // Atualização de usuário
    @PutMapping("/usuario/{userId}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable String userId, @RequestBody Usuario usuario) {
        if ("123".equals(userId)) {
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }

    // Deletando um usuário
    @DeleteMapping("/usuario/{userId}")
    public ResponseEntity<String> excluirUsuario(@PathVariable String userId) {
        if ("123".equals(userId)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário excluído com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
}
