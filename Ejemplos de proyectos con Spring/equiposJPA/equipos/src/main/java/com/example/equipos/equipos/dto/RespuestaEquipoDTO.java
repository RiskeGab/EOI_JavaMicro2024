package com.example.equipos.equipos.dto;

import com.example.equipos.equipos.proyecciones.EquipoSinJugadores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaEquipoDTO {
    private EquipoSinJugadores evento;
}
