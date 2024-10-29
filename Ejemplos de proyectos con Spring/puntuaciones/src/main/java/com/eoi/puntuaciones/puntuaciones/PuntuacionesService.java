package com.eoi.puntuaciones.puntuaciones;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PuntuacionesService {
    private final PuntuacionesRepository puntuacionesRepository;

    public List<Puntuacion> findAll() {
        return (List<Puntuacion>) puntuacionesRepository.findAll();
    }

    public Puntuacion findById(int id) {
        return puntuacionesRepository.findById(id)
            .orElseThrow(() -> 
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Puntuación no encontrada", null));
    }

    public Puntuacion save(Puntuacion p) {
        return puntuacionesRepository.save(p);
    }

    public void delete(int id) {
        puntuacionesRepository.deleteById(id);
    }
}
