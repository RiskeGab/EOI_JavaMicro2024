package com.example.dao;

import java.util.List;

import com.example.entidades.Producto;
import com.example.entidades.Usuario;

public interface UsuarioDAO {
    public List<Usuario> getUsuarios();
    public List<Producto> getFavoritos(int idUsuario);
    public int insertUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void updateUsuario(Usuario usuario);
    public void agregarProductoFavorito(int idUsuario, int idProducto);
    public void eliminarProductoFavorito(int idUsuario, int idProducto);
}
