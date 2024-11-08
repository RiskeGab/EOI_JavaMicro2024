package com.example.equipos.equipos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void delete(int idEvento) {
        equiposRepository.deleteById(idEvento);
    }

    public EquipoSinJugadores update(int id, EquipoDTO equipoDTO) {
        if (!equiposRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipo no encontrado");
        }

        Equipo equipo = Equipo.fromDTO(equipoDTO); 
        equipo.setId(id);
        equiposRepository.save(equipo);
        return equiposRepository.findEquipoById(equipo.getId());
    }
}
