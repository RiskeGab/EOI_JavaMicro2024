package com.example.equipos.equipos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EquipoDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La ciudad no puede estar vacía")
    private String ciudad;
    @NotBlank(message = "El precio no puede ser negativo")
    private String fechaCreacion;
}
