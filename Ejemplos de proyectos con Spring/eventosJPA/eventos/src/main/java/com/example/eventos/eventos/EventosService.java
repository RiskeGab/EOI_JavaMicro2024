package com.example.eventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventosService {
    private final EventosRespository eventosRespository;

    public List<EventoSinUsuarios> getAll() {
        return eventosRespository.findBy();
    }

    public EventoSinUsuarios getById(int id) {
        EventoSinUsuarios e = eventosRespository.findEventoById(id);
        return e;
    }

    public Evento insert(Evento e) {
        e.setId(0);
        return eventosRespository.save(e);
    }

    public Evento update(int id, Evento e) {
        if (!eventosRespository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado");
        }
        e.setId(id);
        return eventosRespository.save(e);
    }

    public void delete(int idEvento) {
        eventosRespository.deleteById(idEvento);
    }
}
