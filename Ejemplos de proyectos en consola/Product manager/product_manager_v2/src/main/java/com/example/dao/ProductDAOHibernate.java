package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
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
    

}
