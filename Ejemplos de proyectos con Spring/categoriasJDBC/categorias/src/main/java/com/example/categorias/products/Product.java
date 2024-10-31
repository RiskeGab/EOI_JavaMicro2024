package com.example.categorias.products;

import java.util.Locale.Category;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private int id;

    private String reference;
    private String name;
    private double price;
    @Column("category")
    private int idCategory;
}
