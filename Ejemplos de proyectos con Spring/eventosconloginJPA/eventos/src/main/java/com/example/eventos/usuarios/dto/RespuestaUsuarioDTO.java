package com.example.eventos.usuarios.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.eventos.usuarios.Usuario;
import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.Data;

@Data
public class RespuestaUsuarioDTO {
    private Usuario usuario;

    public RespuestaUsuarioDTO(UsuarioSinEventos u) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        this.usuario = new Usuario(u.getId(), u.getNombre(), u.getCorreo(), null, baseUrl + "/" + u.getAvatar(), null);
    }
}
