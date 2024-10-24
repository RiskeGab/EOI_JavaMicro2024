package com.eoi;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private final static Scanner sc = new Scanner(System.in);

    private static final String db = "jdbc:mariadb://localhost:3306/puntuaciones";
    private static final String user = "root";
    private static final String pass = "";

    public static void main(String[] args) {
        // Mostrar Menú
        int opcion;
        do {
            System.err.print("""
                    MENÚ
                    -----------------------
                    1) Listar puntuaciones
                    2) Añadir puntuación
                    3) Modificar puntuación
                    4) Borrar puntación
                    ----------------------
                    Elige una opción: """);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // HAcer algo
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }
}
