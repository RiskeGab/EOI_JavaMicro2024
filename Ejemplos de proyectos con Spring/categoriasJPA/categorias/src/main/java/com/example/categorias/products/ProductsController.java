package com.example.categorias.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.categorias.categories.CategoriesService;
import com.example.categorias.products.projections.ProductWithCategory;
import com.example.categorias.products.projections.ProductWithoutCategory;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    public final ProductsService proService;
    public final CategoriesService catService;

    @GetMapping
    public List<ProductWithoutCategory> getProducts(
         @RequestParam() int category
    ) {
        return proService.getProducts(category);
    }

    @GetMapping("/{id}")
    public ProductWithCategory getProduct(@PathVariable int id) {
        return proService.getProduct(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insertProduct(@RequestBody Product c) { 
        return proService.insert(c);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product c, @PathVariable int id) {      
        return proService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        proService.delete(id);
    }
}
