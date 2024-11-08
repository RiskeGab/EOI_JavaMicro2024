package com.example.equipos.jugadores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.equipos.equipos.dto.EquipoDTO;
import com.example.equipos.equipos.dto.RespuestaEquipoDTO;
import com.example.equipos.jugadores.dto.JugadorDTO;
import com.example.equipos.jugadores.dto.RespuestaJugadorDTO;
import com.example.equipos.jugadores.dto.RespuestaJugadoresDTO;

import jakarta.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaJugadorDTO postMethodName(@RequestBody @Valid JugadorDTO j) {        
        return new RespuestaJugadorDTO(jugadoresService.insert(j));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        jugadoresService.delete(id);
    }

    @PutMapping("/{id}")
    public RespuestaJugadorDTO putMethodName(@PathVariable int id, @RequestBody @Valid JugadorDTO j) {
        return new RespuestaJugadorDTO(jugadoresService.update(id, j));
    }
}