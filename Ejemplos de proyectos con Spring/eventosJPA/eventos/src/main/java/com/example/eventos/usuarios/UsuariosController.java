package com.example.eventos.usuarios;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.usuarios.proyecciones.UsuarioSinEventos;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {
    private final UsuariosService usuariosService;

    @GetMapping
    public List<UsuarioSinEventos> getAll() {
        return usuariosService.getAll();
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario u) {       
        return usuariosService.insert(u);
    }
    
}
