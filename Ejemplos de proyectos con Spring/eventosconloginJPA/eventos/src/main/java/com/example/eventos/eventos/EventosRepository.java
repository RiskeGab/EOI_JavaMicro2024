package com.example.eventos.eventos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventos.usuarios.Usuario;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findBy();

    Evento findEventoById(int id);

    List<Evento> findByCreador(Usuario usuario);

    // Update nativo
    // @Query(value = "update evento set titulo = :titulo, descripcion = :descripcion, fecha = :fecha where id = :id", nativeQuery = true)
    // void updateEvento(int id, String titulo, String descripcion, LocalDate fecha);
}
