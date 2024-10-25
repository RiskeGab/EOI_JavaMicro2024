package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Category;
import com.example.entidades.Product;

public class ProductDAOHibernate implements ProductDAO {

    @Override
    public List<Product> getProdutosCategoria(int idCategoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Product> productos = em.createNamedQuery("Product.findByCategory", Product.class)
                                    .setParameter("idCategoria", idCategoria)
                                    .getResultList();
        return productos;
    }

    @Override
    public List<Product> getProductos() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Product> list = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        em.close();
        return list;
    }
    
}
