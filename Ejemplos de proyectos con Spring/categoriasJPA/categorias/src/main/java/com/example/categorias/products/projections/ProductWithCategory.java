package com.example.categorias.products.projections;

import com.example.categorias.categories.projections.CategoryWithoutProducts;

public interface ProductWithCategory {
        int getId();
        String getReference();
        String getName();
        double getPrice();
        CategoryWithoutProducts getCategory();
}
