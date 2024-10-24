package com.eoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.eoi.dao.PuntuacionDAO;
import com.eoi.dao.PuntuacionDAOMariadb;
import com.eoi.entidades.Puntuacion;

/**
 * Hello world!
 *
 */
public class App {
    private final static Scanner sc = new Scanner(System.in);

    private static final String db = "jdbc:mariadb://localhost:3306/puntuaciones";
    private static final String user = "root";
    private static final String pass = "";

    private static PuntuacionDAO puntuacionDAO;

    public static void listarPuntuaciones() {
        puntuacionDAO.getPuntuaciones().forEach(System.out::println);
    }

    public static void insertaPuntuacion() {
        System.out.print("Nombre jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Puntuación: ");
        int puntuacion = sc.nextInt();
        sc.nextLine();
        Puntuacion p = new Puntuacion(0, nombre, puntuacion);
        p = puntuacionDAO.insertPuntuacion(p);
        System.out.println("Puntuacion insertada: " + p);
    }

    public static void actualizaPuntuacion() {
        listarPuntuaciones();
        System.out.print("Puntuación a modificar (id): ");
        int id = sc.nextInt();
        System.out.print("Nueva puntuación: ");
        int puntuacion = sc.nextInt();
        sc.nextLine(); // Borramos buffer sc
        puntuacionDAO.updatePuntuacion(id, puntuacion);
    }

    public static void borraPuntuacion() {
        listarPuntuaciones();
        System.out.print("Puntuación a borrar (id): ");
        int id = sc.nextInt();
        sc.nextLine(); // Borramos buffer sc

        puntuacionDAO.deletePuntuacion(id);
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            puntuacionDAO = new PuntuacionDAOMariadb(conn);
            // Mostrar Menú
            int opcion;
            do {
                System.err.print("""

                        -----------------------
                        MENÚ
                        -----------------------
                        1) Listar puntuaciones
                        2) Añadir puntuación
                        3) Modificar puntuación
                        4) Borrar puntación
                        0) Salir
                        ----------------------
                        Elige una opción: """);
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        listarPuntuaciones();
                        break;
                    case 2:
                        insertaPuntuacion();
                        break;
                    case 3:
                        actualizaPuntuacion();
                        break;
                    case 4:
                        borraPuntuacion();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion != 0);
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
