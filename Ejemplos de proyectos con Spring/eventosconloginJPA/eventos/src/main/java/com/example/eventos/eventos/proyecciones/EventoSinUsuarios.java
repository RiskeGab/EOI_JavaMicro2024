package com.example.eventos.eventos.proyecciones;

import java.time.LocalDate;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

public interface EventoSinUsuarios {
    int getId();
    String getTitulo();
    String getDescripcion();
    double getPrecio();
    LocalDate getFecha();
    String getImagen();
    UsuarioSinEventos getCreador();
}
