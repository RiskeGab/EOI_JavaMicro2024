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

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public RespuestaEventosDTO getAll() {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        List<EventoSinUsuarios> eventos = eventosService.getAll();
        List<Evento> eventosResp = eventos.stream().map(e -> new Evento(e.getId(), e.getTitulo(), e.getDescripcion(),
                e.getPrecio(), e.getFecha(), baseUrl + "/" + e.getImagen(), null)).toList();
        return new RespuestaEventosDTO(eventosResp);
    }

    @GetMapping("/{id}")
    public RespuestaEventoDTO getMethodName(@PathVariable int id) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        EventoSinUsuarios e = eventosService.getById(id);
        Evento eResp = new Evento(e.getId(), e.getTitulo(), e.getDescripcion(), e.getPrecio(), e.getFecha(),
                baseUrl + "/" + e.getImagen(), null);
        return new RespuestaEventoDTO(eResp);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaEventoDTO postMethodName(@RequestBody @Valid EventoDTO eInsert) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        EventoSinUsuarios e = eventosService.insert(eInsert);
        Evento eResp = new Evento(e.getId(), e.getTitulo(), e.getDescripcion(), e.getPrecio(), e.getFecha(),
                baseUrl + "/" + e.getImagen(), null);
        return new RespuestaEventoDTO(eResp);
    }

    @PutMapping("/{id}")
    public RespuestaEventoDTO putMethodName(@PathVariable int id, @RequestBody @Valid EventoDTO eUpdate) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        EventoSinUsuarios e = eventosService.update(id, eUpdate);
        Evento eResp = new Evento(e.getId(), e.getTitulo(), e.getDescripcion(), e.getPrecio(), e.getFecha(),
                baseUrl + "/" + e.getImagen(), null);
        return new RespuestaEventoDTO(eResp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }
}
