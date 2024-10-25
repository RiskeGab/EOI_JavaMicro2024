package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;

import com.example.entidades.Categoria;

public class CategoriaDAOHibernate implements CategoryDAO {
    @Override
    public List<Categoria> getCategorias() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Categoria> list = em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public int insertCategoria(Categoria categoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
        
        return categoria.getId();
    }

    @Override
    public void deleteCategoria(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Categoria categoria = em.getReference(Categoria.class, id);
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }
}
