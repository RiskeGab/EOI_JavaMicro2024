package com.example.dao;

import java.util.List;

import com.example.entidades.Usuario;

public interface UsuarioDAO {
    public List<Usuario> getUsuarios();
    public int insertUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void updateUsuario(Usuario usuario);
}
