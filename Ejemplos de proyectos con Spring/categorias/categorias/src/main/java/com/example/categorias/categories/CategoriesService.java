package com.example.categorias.categories;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    public CategoriesRepository catRepository;

    public List<Category> getCategories() {
        return (List<Category>) catRepository.findAll();
    }
}
