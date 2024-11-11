package com.example.eventos.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.eventos.usuarios.dto.UsuarioDTO;
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

    public UsuarioSinEventos insert(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuariosRepository.save(Usuario.fromDTO(usuarioDTO));
        return usuariosRepository.findUsuarioById(usuario.getId());
    }

    public UsuarioSinEventos update(int id, UsuarioDTO usuarioDTO) {
        if (!usuariosRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        Usuario usuario = Usuario.fromDTO(usuarioDTO);
        usuario.setId(id);
        usuariosRepository.save(usuario);
        return usuariosRepository.findUsuarioById(usuario.getId());
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }
}
