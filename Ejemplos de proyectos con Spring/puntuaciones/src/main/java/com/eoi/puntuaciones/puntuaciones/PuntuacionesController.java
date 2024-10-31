package com.eoi.puntuaciones.puntuaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/puntuaciones")
@RequiredArgsConstructor // Lombok nos genera el constructor
public class PuntuacionesController {
    private final PuntuacionesService puntuacionesService;

    @GetMapping
    public List<Puntuacion> findAll(
        @RequestParam(defaultValue = "0") int puntuacion, // defaultValue hace que sea opcional
        @RequestParam(name = "order",defaultValue = "id") String campoOrderBy, // defaultValue hace que sea opcional
        @RequestParam(required = false) String jugador 
    ) {
        if(jugador == null) {
            return puntuacionesService.findPuntuacionMayor(puntuacion, campoOrderBy);
        } else {
            return puntuacionesService.findByJugador(jugador, campoOrderBy);
        }
    }

    @GetMapping("/{id}")
    public Puntuacion findById(@PathVariable int id) {
        return puntuacionesService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Puntuacion insert(@RequestBody Puntuacion puntuacion) {
        return puntuacionesService.save(puntuacion.withId(0));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        puntuacionesService.delete(id);
    }
}
