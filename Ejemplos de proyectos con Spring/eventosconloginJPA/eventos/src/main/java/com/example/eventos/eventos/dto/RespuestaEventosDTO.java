package com.example.eventos.eventos.dto;

import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.eventos.eventos.Evento;
import com.example.eventos.usuarios.Usuario;

import lombok.Data;

@Data
public class RespuestaEventosDTO {
    private List<Evento> eventos;

    public RespuestaEventosDTO(List<Evento> eventos) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        List<Evento> eventosImg = eventos.stream().map(e -> {
            Usuario u = new Usuario(e.getCreador().getId(), e.getCreador().getNombre(), e.getCreador().getCorreo(),
                    null, baseUrl + "/" + e.getCreador().getAvatar(), null);
            return new Evento(e.getId(), e.getTitulo(), e.getDescripcion(),
                    e.getPrecio(), e.getFecha(), baseUrl + "/" + e.getImagen(), u, null);
        }).toList();

        this.eventos = eventosImg;
    }
}
