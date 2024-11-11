package com.example.eventos.eventos.dto;

import com.example.eventos.eventos.Evento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventoDTO {
    private Evento evento;
}
