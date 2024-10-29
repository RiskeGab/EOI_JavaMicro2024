package com.example.dao;

import java.util.List;

import com.example.entidades.Producto;
import com.example.entidades.Usuario;

public interface UsuarioDAO {
    public List<Usuario> getUsuarios();
    List<Producto> getFavoritos(int idUsuario);
    public int insertUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void updateUsuario(Usuario usuario);
}
