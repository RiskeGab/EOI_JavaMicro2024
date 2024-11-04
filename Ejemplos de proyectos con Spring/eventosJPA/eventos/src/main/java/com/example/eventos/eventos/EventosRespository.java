package com.example.eventos.eventos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

@Repository
public interface EventosRespository extends JpaRepository<Evento, Integer> {
    List<EventoSinUsuarios> findBy();
    //EventoConUsuarios findEventoById(ind id);
}
