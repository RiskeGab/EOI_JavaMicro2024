package com.example.eventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public RespuestaEventosDTO getAll() {
        return new RespuestaEventosDTO(eventosService.getAll());
    }
    
    @GetMapping("/{id}")
    public RespuestaEventoDTO getMethodName(@PathVariable int id) {
        return new RespuestaEventoDTO(eventosService.getById(id));
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaEventoDTO postMethodName(@RequestBody @Valid EventoDTO e) {        
        return new RespuestaEventoDTO(eventosService.insert(e));
    }

    @PutMapping("/{id}")
    public RespuestaEventoDTO putMethodName(@PathVariable int id, @RequestBody @Valid EventoDTO e) {
        return new RespuestaEventoDTO(eventosService.update(id, e));
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }
}
