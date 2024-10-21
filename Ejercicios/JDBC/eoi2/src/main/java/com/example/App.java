package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static final String db = "jdbc:mysql://localhost:3306/eoi2";
    private static final String user = "root";
    private static final String pass = "";

    /**
     * Listar las categorías
     */
    public static void apartado1(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from categorias");

        while(rs.next()) {
            System.out.println(rs.getInt("categoria") + " - " +
                                rs.getString("titulo") + " - " +
                                rs.getInt("salario") + " euros - " +
                                rs.getInt("trienio") + " euros.");
        }
    }

    /**
     * Listar las categorías con printf
     */
    public static void apartado1Printf(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from categorias");

        System.out.printf("\n%3s %-20s %10s %9s\n", "ID", "Título", "Salario", "Trienio");
        System.out.println("-".repeat(45));

        while(rs.next()) {
            System.out.printf("%3d %-20s %10d %9d\n",
                                rs.getInt("categoria"),
                                rs.getString("titulo"),
                                rs.getInt("salario"),
                                rs.getInt("trienio"));
        }
    }

    /**
     * Listar los empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998 (usa
PreparedStatement).
     */
    public static void apartado2(Connection conn) throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from empleados where edad >= ? and contrato < ?");
        
        st.setInt(1, 40);
        st.setDate(2, Date.valueOf("1998-1-1"));

        ResultSet rs = st.executeQuery();

        System.out.println();
        while(rs.next()) {
            System.out.println(rs.getInt("num") + " - " +
                                rs.getString("nombre") + " - " + 
                                rs.getInt("edad") + " - " +
                                rs.getString("contrato"));
        }
    }

    public static void listar(Connection conn) throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from departamentos");
        ResultSet rs = st.executeQuery();

        System.out.println();
        while(rs.next()) {
            System.out.println(rs.getInt("deptno") + " - " +
                               rs.getString("nombre"));
        }
    }

    /**
     * Inserta un departamento (pregunta al usuario usando la consola por un nombre de departamento
y un número). Lista los departamentos para comprobar que se ha insertado. A continuación borra el
departamento que acabas de insertar.
     */
    public static void apartado3(Connection conn) throws SQLException {
        listar(conn);

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número del dpto: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el nombre del dpto: ");
        String nombre = sc.nextLine();

        sc.close();

        PreparedStatement st = conn.prepareStatement("insert into departamentos value (?, ?)");
        
        st.setInt(1, numero);
        st.setString(2, nombre);

        st.executeUpdate();

        listar(conn);
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            apartado1(conn);
            apartado1Printf(conn);
            apartado2(conn);
            apartado3(conn);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
