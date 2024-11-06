package com.example.categorias.products;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.categorias.categories.CategoriesRepository;
import com.example.categorias.products.projections.ProductWithCategory;
import com.example.categorias.products.projections.ProductWithoutCategory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository proRepository;
    private final CategoriesRepository catRepository;

    public List<ProductWithoutCategory> getProducts(int category) {
        return proRepository.findByCategory(category);
    }

    public ProductWithCategory getProduct(int id) {
        return proRepository.findProductById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    public Product insert(Product p) {
        p.setId(0); // Ponemos a 0 para asegurarnos que haya una inserción en vez de una actualización
        return proRepository.save(p);
    }

    public Product update(Product p, int id) {
        if (!proRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        p.setId(id);
        proRepository.save(p);
        return p;
    }

    public void delete(int id) {
        proRepository.deleteById(id);
    }
}
