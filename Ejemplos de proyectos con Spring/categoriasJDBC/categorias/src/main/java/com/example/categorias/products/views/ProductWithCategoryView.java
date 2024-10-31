package com.example.categorias.products.views;

import org.springframework.data.relational.core.mapping.Embedded;

import com.example.categorias.categories.views.CategoryWithoutProductsView;
import com.example.categorias.products.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper=false) @AllArgsConstructor
public class ProductWithCategoryView extends Product {
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "cat_")
    CategoryWithoutProductsView category;
}
