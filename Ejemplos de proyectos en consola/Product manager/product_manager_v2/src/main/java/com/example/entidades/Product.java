package com.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Product {
    int id;
    String referencia;
    String nombre;
    double precio;
    int categoria;

    @Override
    public String toString() {
        return String.format("%5d %5s  %-40s  %8.2f €", id, referencia, nombre, precio, categoria);
    }
}
