package com.example.categorias.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import com.example.categorias.products.projections.ProductWithCategory;
import com.example.categorias.products.projections.ProductWithoutCategory;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p FROM Product p WHERE p.category.id = :category")
    List<ProductWithoutCategory> findByCategory(int category);

    Optional<ProductWithCategory> findProductById(int id);
}
