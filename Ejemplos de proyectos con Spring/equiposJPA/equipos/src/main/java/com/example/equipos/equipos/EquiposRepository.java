package com.example.equipos.equipos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.equipos.equipos.proyecciones.EquipoSinJugadores;

@Repository
public interface EquiposRepository extends JpaRepository<EquipoSinJugadores, Integer> {
    
}
