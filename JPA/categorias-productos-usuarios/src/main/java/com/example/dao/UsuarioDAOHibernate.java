package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Producto;
import com.example.entidades.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO{
    @Override
    public List<Usuario> getUsuarios() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Usuario> list = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
        em.close();

        return list;
    }

    public List<Producto> getFavoritos(int idUsuario) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        Usuario usuario = em.find(Usuario.class, idUsuario);
        List<Producto> favoritos = new ArrayList<>(usuario.getFavoritos()); 
        em.close();

        return favoritos;
    }

    @Override
    public int insertUsuario(Usuario usuario) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();

        return usuario.getId();
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();    
    }

    @Override
    public void deleteUsuario(int idUsuario) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.getReference(Usuario.class, idUsuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }
}
