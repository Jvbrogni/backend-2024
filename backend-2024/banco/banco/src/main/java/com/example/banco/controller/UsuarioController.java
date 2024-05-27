package com.example.banco.controller;

import com.example.banco.controller.represetation.UsuarioDTO;
import com.example.banco.controller.represetation.UsuarioResponseDTO;
import com.example.banco.model.Usuario;
import com.example.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Stream<UsuarioResponseDTO> getUsuario(@PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }

    @GetMapping
    public ResponseEntity getUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(id,usuario));
    }

    @PostMapping
    public ResponseEntity saveUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
}
