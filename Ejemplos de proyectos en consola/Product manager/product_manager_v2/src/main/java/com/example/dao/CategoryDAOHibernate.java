package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Category;

public class CategoryDAOHibernate implements CategoryDAO{

    @Override
    public List<Category> getCategorias() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Category> list = em.createNamedQuery("Category.findAll", Category.class).getResultList();
        em.close();
        return list;
    }
    
}
