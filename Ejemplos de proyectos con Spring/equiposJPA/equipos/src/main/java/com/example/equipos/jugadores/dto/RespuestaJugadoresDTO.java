package com.example.equipos.jugadores.dto;

import java.util.List;

import com.example.equipos.jugadores.proyecciones.JugadorSinEquipo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaJugadoresDTO {
    private List<JugadorSinEquipo> jugadores;
}
