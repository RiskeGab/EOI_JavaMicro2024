package com.example.eventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.eventos.eventos.dto.EventoDTO;
import com.example.eventos.eventos.dto.RespuestaEventoDTO;
import com.example.eventos.eventos.dto.RespuestaEventosDTO;
import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public RespuestaEventosDTO getAll() {
        List<EventoSinUsuarios> eventos = eventosService.getAll();
        return new RespuestaEventosDTO(eventos);
    }

    @GetMapping("/{id}")
    public RespuestaEventoDTO getMethodName(@PathVariable int id) {
        EventoSinUsuarios e = eventosService.getById(id);
        return new RespuestaEventoDTO(e);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaEventoDTO postMethodName(@RequestBody @Valid EventoDTO eInsert) {
        EventoSinUsuarios e = eventosService.insert(eInsert);
        return new RespuestaEventoDTO(e);
    }

    @PutMapping("/{id}")
    public RespuestaEventoDTO putMethodName(@PathVariable int id, @RequestBody @Valid EventoDTO eUpdate) {
        EventoSinUsuarios e = eventosService.update(id, eUpdate);
        return new RespuestaEventoDTO(e);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }
}
