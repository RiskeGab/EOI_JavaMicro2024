package com.example.equipos.jugadores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public JugadorSinEquipo getById(int id) {
        JugadorSinEquipo e = jugadoresRepository.findJugadorById(id);
        return e;
    }

    public JugadorSinEquipo insert(JugadorDTO jugadorDTO) {
        Jugador jugador = jugadoresRepository.save(Jugador.fromDTO(jugadorDTO));
        return jugadoresRepository.findJugadorById(jugador.getId());
    }

    public void delete(int idJugador) {
        jugadoresRepository.deleteById(idJugador);
    }

    public JugadorSinEquipo update(int id, JugadorDTO jugadorDTO) {
        if (!jugadoresRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado");
        }

        Jugador jugador = Jugador.fromDTO(jugadorDTO); 
        jugador.setId(id);
        jugadoresRepository.save(jugador);
        return jugadoresRepository.findJugadorById(jugador.getId());
    }
}