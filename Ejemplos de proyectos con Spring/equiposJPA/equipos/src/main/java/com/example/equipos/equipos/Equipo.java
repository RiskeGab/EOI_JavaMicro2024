package com.example.equipos.equipos;

import java.time.LocalDate;

import com.example.equipos.equipos.dto.EquipoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String ciudad;
    private String fechaCreacion;

    static Equipo fromDTO(EquipoDTO equipoDTO) {
        return new Equipo(0, equipoDTO.getNombre(), equipoDTO.getCiudad(), equipoDTO.getFechaCreacion());
    }
}
