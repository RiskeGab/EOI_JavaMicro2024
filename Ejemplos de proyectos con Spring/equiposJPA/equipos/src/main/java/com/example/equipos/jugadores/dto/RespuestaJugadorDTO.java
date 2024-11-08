package com.example.equipos.jugadores.dto;

import com.example.equipos.jugadores.proyecciones.JugadorSinEquipo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaJugadorDTO {
    private JugadorSinEquipo jugador;
}
