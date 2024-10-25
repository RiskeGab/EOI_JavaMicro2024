package com.example.entidades;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@NamedQueries({
    @NamedQuery(name="Category.findAll", query="select c from Category c")
})
@Data @AllArgsConstructor
public class Category {
    private int id;
    private String nombre;

    @Override
    public String toString() {
        return String.format("%5d %-40s", id, nombre);
    }
}
