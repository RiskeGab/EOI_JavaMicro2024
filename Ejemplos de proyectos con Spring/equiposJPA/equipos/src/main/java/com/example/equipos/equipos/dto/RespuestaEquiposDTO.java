package com.example.equipos.equipos.dto;

import java.util.List;

import com.example.equipos.equipos.proyecciones.EquipoSinJugadores;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaEquiposDTO {
    private List<EquipoSinJugadores> equipos;
}
