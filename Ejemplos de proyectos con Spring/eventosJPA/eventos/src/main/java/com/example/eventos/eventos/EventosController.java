package com.example.eventos.eventos;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public List<EventoSinUsuarios> getAll() {
        return eventosService.getAll();
    }
    
}
