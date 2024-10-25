package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Category;

public class CategoryDAOHibernate implements CategoryDAO {

    @Override
    public List<Category> getCategorias() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Category> list = em.createNamedQuery("Category.findAll", Category.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public int insertCategoria(Category categoria) {
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
        Category categoria = em.getReference(Category.class, id);
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCategoria(Category categoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }
}
