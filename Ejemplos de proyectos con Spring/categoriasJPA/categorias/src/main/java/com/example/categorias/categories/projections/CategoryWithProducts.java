package com.example.categorias.categories.projections;

import java.util.List;

import com.example.categorias.products.projections.ProductWithoutCategory;

public interface CategoryWithProducts {
    int getId(); 
    String getName();
    List<ProductWithoutCategory> getProducts();
}
