package com.example.eventos.usuarios.dto;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuarioDTO {
    private UsuarioSinEventos usuario;
}
