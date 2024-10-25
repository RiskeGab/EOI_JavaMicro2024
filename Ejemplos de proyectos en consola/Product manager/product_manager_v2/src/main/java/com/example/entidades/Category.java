package com.example.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String nombre;

    public Category() {
    }

    @Override
    public String toString() {
        return String.format("%5d %-40s", id, nombre);
    }
}
