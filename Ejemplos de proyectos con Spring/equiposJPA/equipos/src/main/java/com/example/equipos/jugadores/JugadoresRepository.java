package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.equipos.jugadores.proyecciones.JugadorSinEquipo;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugador, Integer> {
        List<JugadorSinEquipo> findBy();
        JugadorSinEquipo findJugadorById(int id);
}
