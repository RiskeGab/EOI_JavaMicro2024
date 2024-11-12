package com.example.eventos.usuarios.dto;

import java.util.List;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaUsuariosDTO {
    private List<UsuarioSinEventos> usuarios;
}
