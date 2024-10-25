package com.example.dao;

import java.util.List;

import com.example.entidades.Categoria;

public interface CategoriaDAO {
    public List<Categoria> getCategorias();
    public int insertCategoria(Categoria categoria);
    public void deleteCategoria(int id);
    public void updateCategoria(Categoria categoria);
}

