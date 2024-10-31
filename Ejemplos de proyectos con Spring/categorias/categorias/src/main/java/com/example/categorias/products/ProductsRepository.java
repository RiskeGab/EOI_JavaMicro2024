package com.example.categorias.products;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductsRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findByCategory(int category);
}
