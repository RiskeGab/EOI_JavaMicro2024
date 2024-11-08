package com.example.equipos.jugadores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.equipos.jugadores.dto.RespuestaJugadoresDTO;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/jugadores")
public class JugadoresController {
    private final JugadoresService jugadoresService;
    
    @GetMapping
    public RespuestaJugadoresDTO getAll() {
        return new RespuestaJugadoresDTO(jugadoresService.getAll());
    }
}