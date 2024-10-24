package com.eoi.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Puntuacion {
    int id;
    String jugador;
    int puntuacion;

    @Override
    public String toString() {
        return String.format("%d. %s -> %d", id, jugador, puntuacion);
    }
}
