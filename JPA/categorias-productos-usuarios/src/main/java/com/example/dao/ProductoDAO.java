package com.example.dao;

import java.util.List;

import com.example.entidades.Producto;

public interface ProductoDAO {
    public List<Producto> getProductos();
    public int insertProducto(Producto Producto, int idCategoria);
    public void deleteProducto(int id);
    public void updateProducto(Producto producto, int idCategoria);
}
