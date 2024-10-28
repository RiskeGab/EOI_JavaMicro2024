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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NamedQueries({
    @NamedQuery(name="Categoria.findAll", query="select c from Categoria c")
})
@Data 
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    @NonNull
    private String nombre;

    @Override
    public String toString() {
        return String.format("%5d %-40s", id, nombre);
    }
}
