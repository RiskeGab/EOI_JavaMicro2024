package com.example.equipos.equipos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.equipos.equipos.dto.EquipoDTO;
import com.example.equipos.equipos.dto.RespuestaEquipoDTO;
import com.example.equipos.equipos.dto.RespuestaEquiposDTO;

import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public RespuestaEquipoDTO getMethodName(@PathVariable int id) {
        return new RespuestaEquipoDTO(equiposService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaEquipoDTO postMethodName(@RequestBody @Valid EquipoDTO e) {        
        return new RespuestaEquipoDTO(equiposService.insert(e));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        equiposService.delete(id);
    }

    @PutMapping("/{id}")
    public RespuestaEquipoDTO putMethodName(@PathVariable int id, @RequestBody @Valid EquipoDTO e) {
        return new RespuestaEquipoDTO(equiposService.update(id, e));
    }
}
