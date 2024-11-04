package com.example.eventos.eventos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventosService {
    private final EventosRespository eventosRespository;

    public List<EventoSinUsuarios> getAll() {
        return eventosRespository.findBy();
    }
}
