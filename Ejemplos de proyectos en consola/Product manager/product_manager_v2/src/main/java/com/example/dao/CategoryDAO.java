package com.example.dao;

import java.util.List;

import com.example.entidades.Category;

public interface CategoryDAO {
    public List<Category> getCategorias();
    public void insertCategoria(Category categoria);
    public void deleteCategoria(int id);
}
