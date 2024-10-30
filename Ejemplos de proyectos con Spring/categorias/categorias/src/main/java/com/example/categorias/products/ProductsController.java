package com.example.categorias.products;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    public final ProductsService proService;

    @GetMapping
    public List<Product> getProducts() {
        return proService.getProducts();
    }
}
