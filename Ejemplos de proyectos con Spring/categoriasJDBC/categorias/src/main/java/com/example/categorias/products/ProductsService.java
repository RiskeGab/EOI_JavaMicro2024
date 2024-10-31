package com.example.categorias.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.categorias.products.views.ProductWithCategoryView;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository proRepository;

    public List<Product> getProducts(int category) {
        return proRepository.findByIdCategory(category);
    }

    public ProductWithCategoryView getProduct(int id) {
        return proRepository.findByIdWithCategory(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    public Product insert(Product c) {
        c.setId(0); // Ponemos a 0 para asegurarnos que haya una inserción en vez de una actualización
        return proRepository.save(c);
    }

    public Product update(Product c, int id) {
        if (!proRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        c.setId(id);
        return proRepository.save(c);
    }

    public void delete(int id) {
        proRepository.deleteById(id);
    }
}
