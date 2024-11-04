package com.example.eventos.eventos;

import java.time.LocalDate;
import java.util.List;

import com.example.eventos.usuarios.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private double precio;
    private LocalDate fecha;

    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios;
}
