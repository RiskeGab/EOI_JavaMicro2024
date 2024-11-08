package com.example.equipos.jugadores.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JugadorDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La número del jugador no puede estar vacío")
    private int numero;
    @NotBlank(message = "El sueldo del jugador no puede estar vacío")
    private double sueldo;
    @NotBlank(message = "El equipo del jugador no puede estar vacío")
    private int equipo;
}
