package com.example.categorias.products;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository proRepository;

    public List<Product> getProducts(int category) {
        return proRepository.findByCategory(category);
    }
}
