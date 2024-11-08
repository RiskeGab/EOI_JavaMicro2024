package com.example.equipos.equipos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EquipoDTO {
    @NotBlank(message = "El nombre del equipo no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La ciudad del equipo no puede estar vacía")
    private String ciudad;
    @NotBlank(message = "La fecha de creación del equipo no puede estar vacía")
    private String fechaCreacion;
}
