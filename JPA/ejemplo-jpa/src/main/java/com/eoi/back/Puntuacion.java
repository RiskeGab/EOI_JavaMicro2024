package com.eoi.back;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "puntuacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Puntuacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String jugador;
    int puntuacion; 
}
