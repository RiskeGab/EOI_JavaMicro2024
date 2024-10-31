package com.eoi.puntuaciones.puntuaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Puntuacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; 
    String jugador;
    int puntuacion; 
}
