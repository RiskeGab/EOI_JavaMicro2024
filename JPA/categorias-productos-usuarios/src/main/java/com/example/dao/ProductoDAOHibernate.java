package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.conexion.EntityManagerBuilder;
import com.example.entidades.Categoria;
import com.example.entidades.Producto;

public class ProductoDAOHibernate implements ProductoDAO {

    @Override
    public void deleteProducto(int idProducto) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Producto producto = em.getReference(Producto.class, idProducto);
        em.remove(producto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Producto> getProductos() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Producto> list = em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
        em.close();

        return list;
    }

    @Override
    public int insertProducto(Producto producto, int idCategoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Categoria categoria = em.getReference(Categoria.class, idCategoria);
        producto.setCategoria(categoria);
        em.persist(producto);
        em.getTransaction().commit();
        em.close();

        return producto.getId();
    }

    @Override
    public void updateProducto(Producto producto, int idCategoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Categoria categoria = em.getReference(Categoria.class, idCategoria);
        producto.setCategoria(categoria);
        em.merge(producto);
        em.getTransaction().commit();
        em.close();
    }
}
