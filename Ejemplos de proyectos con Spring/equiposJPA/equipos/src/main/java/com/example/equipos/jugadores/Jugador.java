package com.example.equipos.jugadores;

import com.example.equipos.jugadores.dto.JugadorDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int numero;
    private double sueldo;
    private int equipo;

    static Jugador fromDTO(JugadorDTO jugadorDTO) {
        return new Jugador(0, jugadorDTO.getNombre(), jugadorDTO.getNumero(), jugadorDTO.getSueldo(), jugadorDTO.getEquipo());
    }
}
