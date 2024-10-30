package com.example.categorias.categories;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    public final CategoriesRepository catRepository;

    public List<Category> getCategories() {
        return (List<Category>) catRepository.findAll();
    }

    public Category getCategory(int id) {
        return catRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }

    public Category insert(Category c) {
        //c.setId(0); // Ponemos a 0 para asegurarnos que haya una inserción en vez de una actualización
        return catRepository.save(c);
    }
}
