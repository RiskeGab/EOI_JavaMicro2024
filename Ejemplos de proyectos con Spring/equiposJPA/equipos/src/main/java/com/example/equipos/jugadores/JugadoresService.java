package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.equipos.jugadores.proyecciones.JugadorSinEquipo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {
    private final JugadoresRepository equiposRepository;

    public List<JugadorSinEquipo> getAll() {
        return equiposRepository.findBy();
    }
}