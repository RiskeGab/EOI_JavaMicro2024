package com.example.categorias.categories;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.categorias.categories.projections.CategoryWithProducts;
import com.example.categorias.categories.projections.CategoryWithoutProducts;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    public final CategoriesRepository catRepository;

    public List<CategoryWithoutProducts> getCategories() {
        return catRepository.findAllBy();
    }

    public CategoryWithProducts getCategory(int id) {
        return catRepository.findCategoryById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }

    public Category insert(Category c) {
        c.setId(0); // Ponemos a 0 para asegurarnos que haya una inserción en vez de una actualización
        return catRepository.save(c);
    }

    public Category update(Category c, int id) {
        if (!catRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada");
        }
        c.setId(id);
        return catRepository.save(c);
    }

    public void delete(int id) {
        catRepository.deleteById(id);
    }
}
