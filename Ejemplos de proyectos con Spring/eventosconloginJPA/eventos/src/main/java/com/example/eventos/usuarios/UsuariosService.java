package com.example.eventos.usuarios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.eventos.auth.dto.LoginDTO;
import com.example.eventos.usuarios.dto.UsuarioDTO;
import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;
import com.example.eventos.utils.ImageUtils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;
    private final @NonNull ImageUtils imageUtils;

    List<UsuarioSinEventos> getAll() {
        return usuariosRepository.findBy();
    }

    public UsuarioSinEventos getById(int id) {
        UsuarioSinEventos u = usuariosRepository.findUsuarioById(id);
        return u;
    }

    public UsuarioSinEventos insert(UsuarioDTO usuarioDTO) throws NoSuchAlgorithmException {
        usuarioDTO.setPassword(encodePassword(usuarioDTO.getPassword()));
        usuarioDTO.setAvatar(imageUtils.saveImageBase64("usuarios", usuarioDTO.getAvatar()));
        Usuario usuario = usuariosRepository.save(Usuario.fromDTO(usuarioDTO));
        return usuariosRepository.findUsuarioById(usuario.getId());
    }

    public UsuarioSinEventos update(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!usuarioDTO.getAvatar().startsWith("http")) { // La imagen viene en Base64
            usuarioDTO.setAvatar(imageUtils.saveImageBase64("eventos", usuarioDTO.getAvatar()));
        }
        Usuario usuarioUpdate = Usuario.fromDTO(usuarioDTO);
        usuarioUpdate.setId(id);
        usuarioUpdate.setPassword(usuario.getPassword());
        usuariosRepository.save(usuarioUpdate);
        return usuariosRepository.findUsuarioById(usuario.getId());
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }

    public Usuario login(LoginDTO loginDTO) throws NoSuchAlgorithmException {
        return usuariosRepository.findByCorreoAndPassword(loginDTO.getCorreo(), encodePassword(loginDTO.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado"));
    }

    private String encodePassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);
        return encodedPass;
    }

}
