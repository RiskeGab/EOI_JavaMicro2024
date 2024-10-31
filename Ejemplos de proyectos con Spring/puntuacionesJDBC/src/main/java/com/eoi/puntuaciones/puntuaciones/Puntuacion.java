package com.eoi.puntuaciones.puntuaciones;

import org.springframework.data.annotation.Id;

import lombok.With;

@With
public record Puntuacion(@Id Integer id, String jugador, int puntuacion) {}
