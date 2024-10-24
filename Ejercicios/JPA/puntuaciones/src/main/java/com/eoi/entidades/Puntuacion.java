package com.eoi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "puntuacion")
@Data @AllArgsConstructor @NoArgsConstructor
public class Puntuacion {
    @Id int id;
    @Column(nullable = false)
    String jugador;
    int puntuacion;

    @Override
    public String toString() {
        return String.format("%d. %s -> %d", id, jugador, puntuacion);
    }
}
