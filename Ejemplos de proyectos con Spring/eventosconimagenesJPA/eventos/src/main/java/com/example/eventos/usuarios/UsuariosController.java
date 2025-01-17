package com.example.eventos.usuarios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.usuarios.dto.RespuestaUsuarioDTO;
import com.example.eventos.usuarios.dto.RespuestaUsuariosDTO;
import com.example.eventos.usuarios.dto.UsuarioDTO;
import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {
    private final UsuariosService usuariosService;

    @GetMapping
    public RespuestaUsuariosDTO getAll() {
        return new RespuestaUsuariosDTO(usuariosService.getAll());
    }

    @GetMapping("/{id}")
    public RespuestaUsuarioDTO getById(@PathVariable int id) {
        return new RespuestaUsuarioDTO(usuariosService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaUsuarioDTO insert(@RequestBody @Valid UsuarioDTO u) {       
        return new RespuestaUsuarioDTO(usuariosService.insert(u));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespuestaUsuarioDTO update(@PathVariable int id, @RequestBody @Valid UsuarioDTO u) {      
        return new RespuestaUsuarioDTO(usuariosService.update(id, u));
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        usuariosService.delete(id);
    }
}
