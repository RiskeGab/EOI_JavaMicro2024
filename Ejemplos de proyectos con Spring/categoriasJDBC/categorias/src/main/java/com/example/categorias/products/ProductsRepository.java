package com.example.categorias.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.example.categorias.products.views.ProductWithCategoryView;

public interface ProductsRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findByIdCategory(int category);

    @Query("SELECT p.*,c.id as cat_id, c.name as cat_name FROM product p JOIN category c ON c.id = p.category WHERE p.id = :id")
    Optional<ProductWithCategoryView> findByIdWithCategory(int id);
}
