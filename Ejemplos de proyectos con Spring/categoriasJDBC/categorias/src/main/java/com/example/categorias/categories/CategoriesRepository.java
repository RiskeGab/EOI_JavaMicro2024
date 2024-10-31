package com.example.categorias.categories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.example.categorias.categories.views.CategoryWithoutProductsView;

public interface CategoriesRepository extends ListCrudRepository<Category, Integer>{
    @Query("SELECT * FROM category")
    List<CategoryWithoutProductsView> findAllBy();
}
