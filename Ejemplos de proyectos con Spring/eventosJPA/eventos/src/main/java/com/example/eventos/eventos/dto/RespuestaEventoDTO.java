package com.example.eventos.eventos.dto;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventoDTO {
    private EventoSinUsuarios evento;
}
