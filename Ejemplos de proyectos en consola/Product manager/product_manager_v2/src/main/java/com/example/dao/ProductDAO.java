package com.example.dao;

import java.util.List;

import com.example.entidades.Product;

public interface ProductDAO {
    public List<Product> getProductos();
    public void insertProducto(Product producto);
    public void deleteProducto(int id);
    public void updateProducto(Product producto);
}
