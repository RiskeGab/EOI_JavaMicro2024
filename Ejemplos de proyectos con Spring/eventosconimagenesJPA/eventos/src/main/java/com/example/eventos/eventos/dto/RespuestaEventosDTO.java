package com.example.eventos.eventos.dto;

import java.util.List;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventosDTO {
    private List<EventoSinUsuarios> eventos;
}
