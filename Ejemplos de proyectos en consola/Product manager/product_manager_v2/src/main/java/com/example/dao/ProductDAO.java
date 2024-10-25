package com.example.dao;

import java.util.List;

import com.example.entidades.Product;

public interface ProductDAO {
    List<Product> getProdutosCategoria(int idCategoria);
    public List<Product> getProductos();
    public int insertProducto(Product producto, int categoria);
}
