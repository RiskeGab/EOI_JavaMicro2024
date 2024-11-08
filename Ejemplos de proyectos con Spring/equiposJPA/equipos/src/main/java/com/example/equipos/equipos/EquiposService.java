package com.example.equipos.equipos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.equipos.equipos.proyecciones.EquipoSinJugadores;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquiposService {
    private final EquiposRepository equiposRepository;

    public List<EquipoSinJugadores> getAll() {
        return equiposRepository.findAll();
    }
}
