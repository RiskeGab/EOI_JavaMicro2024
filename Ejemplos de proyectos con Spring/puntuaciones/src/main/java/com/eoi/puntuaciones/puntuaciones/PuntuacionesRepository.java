package com.eoi.puntuaciones.puntuaciones;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface PuntuacionesRepository extends ListCrudRepository<Puntuacion, Integer> {
    // @Query("SELECT * from puntuacion WHERE puntuacion >= :puntuacion")
    // List<Puntuacion> findPuntuacionMayor(int puntuacion);

    // Esto equivale al méto de arriba, y además ordena
    List<Puntuacion> findByPuntuacionGreaterThan(int puntuacion, Sort sort);

    List<Puntuacion> findByJugadorContaining(String jugador, Sort sort);
}
