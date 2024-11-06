package com.example.categorias.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.categorias.categories.projections.CategoryWithProducts;
import com.example.categorias.categories.projections.CategoryWithoutProducts;

public interface CategoriesRepository extends JpaRepository<Category, Integer>{
    List<CategoryWithoutProducts> findAllBy();

    Optional<CategoryWithProducts> findCategoryById(int id);
}
