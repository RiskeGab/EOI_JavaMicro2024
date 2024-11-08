package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.equipos.jugadores.dto.JugadorDTO;
import com.example.equipos.jugadores.proyecciones.JugadorSinEquipo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JugadoresService {
    private final JugadoresRepository jugadoresRepository;

    public List<JugadorSinEquipo> getAll() {
        return jugadoresRepository.findBy();
    }

    public JugadorSinEquipo insert(JugadorDTO jugadorDTO) {
        Jugador jugador = jugadoresRepository.save(Jugador.fromDTO(jugadorDTO));
        return jugadoresRepository.findEquipoById(jugador.getId());
    }

    public void delete(int idJugador) {
        jugadoresRepository.deleteById(idJugador);
    }
}