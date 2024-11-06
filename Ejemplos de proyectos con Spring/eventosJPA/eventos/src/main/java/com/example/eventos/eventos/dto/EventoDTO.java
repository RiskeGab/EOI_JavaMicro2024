package com.example.eventos.eventos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EventoDTO {
    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 4, message = "El título debe tener al menos 4 caracteres")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @Positive(message = "El precio no puede ser negativo")
    private double precio;
    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "La fecha no tiene un formato correcto")
    private String fecha;
}
