package com.eoi.dao;

import java.util.List;

import com.eoi.entidades.Puntuacion;

public interface PuntuacionDAO {
    List<Puntuacion> getPuntuaciones();
    Puntuacion insertPuntuacion(Puntuacion puntuacion);
    void updatePuntuacion(int id, int puntuacion);
    void deletePuntuacion(int id);
}
