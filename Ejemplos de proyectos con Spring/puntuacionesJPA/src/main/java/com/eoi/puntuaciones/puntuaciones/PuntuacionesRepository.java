package com.eoi.puntuaciones.puntuaciones;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntuacionesRepository extends JpaRepository<Puntuacion, Integer> {
    // @Query("SELECT * from puntuacion WHERE puntuacion >= :puntuacion")
    // List<Puntuacion> findPuntuacionMayor(int puntuacion);

    // Esto equivale al méto de arriba, y además ordena
    List<Puntuacion> findByPuntuacionGreaterThan(int puntuacion, Sort sort);

    List<Puntuacion> findByJugadorContaining(String jugador, Sort sort);
}
