package com.eoi.back;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void listarPuntuaciones() {
        List<Puntuacion> puntuaciones;
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        // Obtenemos la categoría con la id recibida
        puntuaciones = em.createQuery("from Puntuacion").getResultList();
        em.close();

        puntuaciones.forEach(System.out::println);
    }

    public static void insertaPuntuacion() {
        System.out.print("Nombre jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Puntuación: ");
        int puntuacion = sc.nextInt();
        sc.nextLine();

        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Puntuacion p = new Puntuacion();
        p.setJugador(nombre);
        p.setPuntuacion(puntuacion);
        em.persist(p); // Insert
        em.getTransaction().commit();
        em.close();
    }

    public static void mostrarPuntuacion(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        // Obtenemos la categoría con la id recibida
        Puntuacion p = em.find(Puntuacion.class, id);
        System.out.println(p);
        em.close();
    }

    public static void modificaPuntuacion(int id) {
        System.out.print("Puntuación: ");
        int puntuacion = sc.nextInt();
        sc.nextLine();

        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Puntuacion p = em.find(Puntuacion.class, id);
        p.setPuntuacion(puntuacion);
        em.getTransaction().commit();
        em.close();
    }

    public static void borraPuntuacion(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Puntuacion p = em.find(Puntuacion.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        insertaPuntuacion();
        listarPuntuaciones();
        // modificaPuntuacion(1);
        // mostrarPuntuacion(1);
        // borraPuntuacion(5);
    }
}
