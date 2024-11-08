package com.example.equipos.jugadores.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JugadorDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @Positive(message = "El número del jugador no puede ser negativo")
    private int numero;
    @Positive(message = "El sueldo de un jugador no puede ser negativo")
    private double sueldo;
    @Positive(message = "El equipo de un jugador no puede ser negativo")
    private int equipo;
}
