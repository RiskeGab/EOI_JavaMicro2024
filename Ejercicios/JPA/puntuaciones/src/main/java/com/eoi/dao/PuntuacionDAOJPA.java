package com.eoi.dao;

import java.util.List;

import com.eoi.EntityManagerBuilder;
import com.eoi.entidades.Puntuacion;

import jakarta.persistence.EntityManager;

public class PuntuacionDAOJPA  implements PuntuacionDAO {

    @Override
    public List<Puntuacion> getPuntuaciones() {
        List<Puntuacion> puntuaciones;
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        // Obtenemos la categoría con la id recibida
        puntuaciones = em.createQuery("from Puntuacion").getResultList();
        em.close();
        return puntuaciones;
    }

    @Override
    public Puntuacion insertPuntuacion(Puntuacion puntuacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPuntuacion'");
    }

    @Override
    public void updatePuntuacion(int id, int puntuacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePuntuacion'");
    }

    @Override
    public void deletePuntuacion(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePuntuacion'");
    }
    
}
