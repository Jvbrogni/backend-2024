package com.example.banco.controller.represetation;

import com.example.banco.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO {
    private int id;
    private String nome;
    private String cidade;
    private String email;
    private String telefone;
    public static UsuarioDTO fromEntity (Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.id = usuario.getId();
        dto.nome = usuario.getName();
        dto.cidade = usuario.getCidade();
        dto.email = usuario.getEmail();
        dto.telefone = usuario.getTelefone();
        return dto;
    }

    public static List<UsuarioDTO> fromEntity(List<Usuario> clientes) {
        return clientes.stream().map(UsuarioDTO::fromEntity).collect(Collectors.toList());
    }
}
