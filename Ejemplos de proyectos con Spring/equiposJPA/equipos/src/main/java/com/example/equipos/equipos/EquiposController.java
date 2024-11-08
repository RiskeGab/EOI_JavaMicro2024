package com.example.equipos.equipos;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.equipos.equipos.dto.RespuestaEquiposDTO;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/equipos")
public class EquiposController {
    private final EquiposService equiposService;
    
    @GetMapping
    public RespuestaEquiposDTO getAll() {
        return new RespuestaEquiposDTO(equiposService.getAll());
    }

}
