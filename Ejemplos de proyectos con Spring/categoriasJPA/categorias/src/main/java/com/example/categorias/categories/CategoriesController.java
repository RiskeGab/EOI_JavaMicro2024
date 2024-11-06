package com.example.categorias.categories;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.categorias.categories.projections.CategoryWithProducts;
import com.example.categorias.categories.projections.CategoryWithoutProducts;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService catService;

    @GetMapping
    public List<CategoryWithoutProducts> getCategories() {
        return catService.getCategories();
    }
    
    @GetMapping("/{id}")
    public CategoryWithProducts getCategory(@PathVariable int id) {
        return catService.getCategory(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category c) { 
        return catService.insert(c);
    }
    
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category c, @PathVariable int id) {      
        return catService.update(c, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        catService.delete(id);
    }
}
