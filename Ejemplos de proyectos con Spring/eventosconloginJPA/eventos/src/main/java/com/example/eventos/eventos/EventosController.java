package com.example.eventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.eventos.dto.EventoDTO;
import com.example.eventos.eventos.dto.RespuestaEventoDTO;
import com.example.eventos.eventos.dto.RespuestaEventosDTO;
import com.example.eventos.usuarios.dto.RespuestaUsuariosDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public RespuestaEventosDTO getAll() {
        List<Evento> eventos = eventosService.getAll();
        return new RespuestaEventosDTO(eventos);
    }

    @GetMapping("/{id}")
    public RespuestaEventoDTO getEventos(@PathVariable int id) {
        Evento e = eventosService.getById(id);
        return new RespuestaEventoDTO(e);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaEventoDTO postEvento(@RequestBody @Valid EventoDTO eInsert) {
        Evento e = eventosService.insert(eInsert);
        return new RespuestaEventoDTO(e);
    }

    @PutMapping("/{id}")
    public RespuestaEventoDTO updateEvento(@PathVariable int id, @RequestBody @Valid EventoDTO eUpdate) {
        Evento e = eventosService.update(id, eUpdate);
        return new RespuestaEventoDTO(e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }

    @PostMapping("/{id}/asistir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void asisteEvento(@PathVariable int id) {
        eventosService.asistirEvento(id);
    }
    
    @DeleteMapping("/{id}/asistir")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borraAsistencia(@PathVariable int id) {
        eventosService.borraAsistencia(id);
    }

    @GetMapping("/{id}/usuarios")
    public RespuestaUsuariosDTO usuariosAsisten(@PathVariable int id) {
        return new RespuestaUsuariosDTO(eventosService.getAsistentesEvento(id));
    }
    
}
