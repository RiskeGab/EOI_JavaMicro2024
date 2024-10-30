package com.example.categorias.categories;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

    @GetMapping
    public List<Category> getCategories() {
        return null;
    }
    
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return null;
    }
    
    @PostMapping
    public Category insertCategory(@RequestBody Category c) { 
        return null;
    }
    
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category c, @PathVariable int id) {      
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
    }
    
}
