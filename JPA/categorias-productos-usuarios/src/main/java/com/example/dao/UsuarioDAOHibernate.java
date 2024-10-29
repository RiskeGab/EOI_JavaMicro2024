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

    @Override
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
    public void agregarProductoFavorito(int idUsuario, int idProducto) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
    
        // Buscar el usuario y el producto por sus IDs
        Usuario usuario = em.find(Usuario.class, idUsuario);
        Producto producto = em.find(Producto.class, idProducto);
    
        // Verificar si ambos existen
        if (usuario != null && producto != null) {
            usuario.getFavoritos().add(producto);  // Agregar el producto a favoritos
            em.merge(usuario);  // Guardar los cambios en la base de datos
        } else {
            System.out.println("Usuario o producto no encontrado.");
        }
    
        em.getTransaction().commit();
        em.close();
    } 

    @Override
    public void eliminarProductoFavorito(int idUsuario, int idProducto) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
    
        // Buscar el usuario por su ID
        Usuario usuario = em.find(Usuario.class, idUsuario);
    
        // Si el usuario existe, eliminar el producto de sus favoritos
        if (usuario != null) {
            Producto producto = em.find(Producto.class, idProducto);
            if (producto != null && usuario.getFavoritos().contains(producto)) {
                usuario.getFavoritos().remove(producto);  // Eliminar el producto de favoritos
                em.merge(usuario);  // Guardar los cambios en la base de datos
                System.out.println("Producto eliminado de favoritos.");
            } else {
                System.out.println("Producto no encontrado en los favoritos del usuario.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    
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
