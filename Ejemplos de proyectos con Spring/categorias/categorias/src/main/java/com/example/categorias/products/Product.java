package com.example.categorias.products;

import org.springframework.data.annotation.Id;

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
    private int category;
}