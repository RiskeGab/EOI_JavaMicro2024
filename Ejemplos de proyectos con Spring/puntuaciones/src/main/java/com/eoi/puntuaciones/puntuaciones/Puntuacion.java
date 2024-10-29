package com.eoi.puntuaciones.puntuaciones;

import org.springframework.data.annotation.Id;

public record Puntuacion(@Id Integer id, String jugador, int puntuacion) {}
