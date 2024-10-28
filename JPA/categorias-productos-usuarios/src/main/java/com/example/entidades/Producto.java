package com.example.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NamedQueries({
    @NamedQuery(name="Producto.findAll", query="select p from Producto p")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String referencia;

    @NonNull
    private String nombre;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    public Producto(@NonNull String referencia, @NonNull String nombre, double precio, Categoria categoria) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %-30s %10.2f -", id, referencia, nombre, precio) + categoria;
    }
}
