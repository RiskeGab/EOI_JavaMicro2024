package com.example.eventos.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
    List<UsuarioSinEventos> findBy();

    //UsuarioConEventos findUsuarioById(@Param("id") int id);
}
