package com.example.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Category {
    private int id;
    private String nombre;

    @Override
    public String toString() {
        return String.format("%5d %-40s", id, nombre);
    }
}
