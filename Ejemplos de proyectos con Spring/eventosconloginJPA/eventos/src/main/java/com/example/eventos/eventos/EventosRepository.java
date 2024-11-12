package com.example.eventos.eventos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer> {
    List<EventoSinUsuarios> findBy();

    EventoSinUsuarios findEventoById(int id);

    // Update nativo
    // @Query(value = "update evento set titulo = :titulo, descripcion = :descripcion, fecha = :fecha where id = :id", nativeQuery = true)
    // void updateEvento(int id, String titulo, String descripcion, LocalDate fecha);
}
