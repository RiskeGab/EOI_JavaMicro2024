package com.example.entidades;

public class Product {
    int id;
    String referencia;
    String nombre;
    double precio;
    int categoria;
    
    public Product(int id, String referencia, String nombre, double precio, int categoria) {
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%5d %5s  %-40s  %8.2f €", id, referencia, nombre, precio, categoria);
    }
}
