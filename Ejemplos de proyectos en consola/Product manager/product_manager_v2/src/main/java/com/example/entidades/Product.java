package com.example.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@NamedQueries({
    @NamedQuery(name="Product.findAll", query="select p from Product p"),
    @NamedQuery(name="Product.findByCategory", query="select p from Product p where p.categoria.id = :idCategoria")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "reference")
    String referencia;

    @Column(name = "name")
    String nombre;

    @Column(name = "price")
    double precio;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category")
    Category categoria; 

    @Override
    public String toString() {
        return String.format("%5d %5s  %-40s  %8.2f €", id, referencia, nombre, precio, categoria);
    }
}
