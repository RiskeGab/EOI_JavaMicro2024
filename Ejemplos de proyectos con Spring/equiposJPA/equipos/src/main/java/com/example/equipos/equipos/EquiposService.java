package com.example.equipos.equipos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.equipos.equipos.dto.EquipoDTO;
import com.example.equipos.equipos.proyecciones.EquipoSinJugadores;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquiposService {
    private final EquiposRepository equiposRepository;

    public List<EquipoSinJugadores> getAll() {
        return equiposRepository.findBy();
    }

    public EquipoSinJugadores insert(EquipoDTO equipoDTO) {
        Equipo equipo = equiposRepository.save(Equipo.fromDTO(equipoDTO));
        return equiposRepository.findEquipoById(equipo.getId());
    }
}
