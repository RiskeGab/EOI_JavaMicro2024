package com.example.eventos.eventos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final EventosService eventosService;

    @GetMapping
    public List<EventoSinUsuarios> getAll() {
        return eventosService.getAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento postMethodName(@RequestBody Evento e) {        
        return eventosService.insert(e);
    }

    @PutMapping("/{id}")
    public Evento putMethodName(@PathVariable int id, @RequestBody Evento e) {
        return eventosService.update(id, e);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        eventosService.delete(id);
    }
}
