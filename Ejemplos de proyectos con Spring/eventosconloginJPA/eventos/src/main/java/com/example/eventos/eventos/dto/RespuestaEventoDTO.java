package com.example.eventos.eventos.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.eventos.eventos.Evento;
import com.example.eventos.usuarios.Usuario;

import lombok.Data;

@Data
public class RespuestaEventoDTO {
    private Evento evento;

    public RespuestaEventoDTO(Evento e) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        Usuario u = new Usuario(e.getCreador().getId(), e.getCreador().getNombre(), e.getCreador().getCorreo(),
                    null, e.getCreador().getAvatar(), null);
        Evento eventoImg = new Evento(e.getId(), e.getTitulo(), e.getDescripcion(),
                    e.getPrecio(), e.getFecha(), baseUrl + "/" + e.getImagen(), u, null);
        this.evento = eventoImg;
    }
}
