package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Product;
import com.example.entidades.Category;

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

    @Override
    public int insertProducto(Product producto, int idCategoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        
        Category categoria = em.find(Category.class, idCategoria);
        producto.setCategoria(categoria);

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
        
        return producto.getId();
    }

    @Override
    public void deleteProducto(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Product producto = em.getReference(Product.class, id);

        System.out.println(producto);

        em.remove(producto);
        em.getTransaction().commit();
        em.close();
    }    
}
