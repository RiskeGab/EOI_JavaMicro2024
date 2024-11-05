package com.example.eventos.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    List<UsuarioSinEventos> getAll() {
        return usuariosRepository.findBy();
    }

    public UsuarioSinEventos getById(int id) {
        UsuarioSinEventos u = usuariosRepository.findUsuarioById(id);
        return u;
    }

    public Usuario insert(Usuario u) {
        u.setId(0);
        return usuariosRepository.save(u);
    }

    public Usuario update(int id, Usuario u) {
        if (!usuariosRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        u.setId(id);
        return usuariosRepository.save(u);
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }
}
