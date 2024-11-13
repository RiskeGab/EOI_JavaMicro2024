package com.example.eventos.usuarios.dto;

import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.eventos.usuarios.Usuario;

import lombok.Data;

@Data
public class RespuestaUsuariosDTO {
    private List<Usuario> usuarios;

    public RespuestaUsuariosDTO(List<Usuario> usuarios) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        this.usuarios = usuarios.stream().map(u -> {
            return new Usuario(u.getId(), u.getNombre(), u.getCorreo(), null, baseUrl + "/" + u.getAvatar(), null);
        }).toList();
    }
}
