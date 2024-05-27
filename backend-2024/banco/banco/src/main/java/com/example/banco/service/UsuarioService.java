package com.example.banco.service;

import com.example.banco.controller.represetation.UsuarioResponseDTO;
import com.example.banco.model.Usuario;
import com.example.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usersRepository;

    public UsuarioResponseDTO save(Usuario entity) {
        return convertToResponseDto(usersRepository.save(entity));
    }

    public Stream<UsuarioResponseDTO> findById(Long id) {
        return usersRepository.findById(id)
                .stream()
                .map(this::convertToResponseDto);
    }

    public List<UsuarioResponseDTO> findAll() {
        return usersRepository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO update(Long id, Usuario entity) {
        Usuario usuario = usersRepository.findById(id).orElse(null);

        if(usuario == null) {
            return null;
        }
        usuario.setCidade(entity.getCidade());
        usuario.setEmail(entity.getEmail());
        usuario.setName(entity.getName());
        usuario.setTelefone(entity.getTelefone());
        return convertToResponseDto(usersRepository.save(usuario));
    }

    private UsuarioResponseDTO convertToResponseDto(Usuario entity) {
        return new UsuarioResponseDTO(entity.getId(),entity.getName(),entity.getCidade());
    }

    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
