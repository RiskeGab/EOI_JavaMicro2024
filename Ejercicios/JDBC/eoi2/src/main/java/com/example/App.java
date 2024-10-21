package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            apartado1(conn);
            apartado1Printf(conn);
            apartado2(conn);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
