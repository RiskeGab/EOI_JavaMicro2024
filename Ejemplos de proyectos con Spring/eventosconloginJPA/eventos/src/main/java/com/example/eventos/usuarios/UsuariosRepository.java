package com.example.eventos.usuarios;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
    List<Usuario> findBy();

    Usuario findUsuarioById(int id);

    Optional<Usuario> findByCorreoAndPassword(String correo, String password);
}
