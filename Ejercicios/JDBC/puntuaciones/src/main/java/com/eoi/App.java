package com.eoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.eoi.dao.PuntuacionDAO;
import com.eoi.dao.PuntuacionDAOMariadb;

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
                switch (opcion) {
                    case 1:
                        listarPuntuaciones();
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
