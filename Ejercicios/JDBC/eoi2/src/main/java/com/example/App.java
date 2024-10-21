package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public static void apartado1() {
        try (Connection conn = DriverManager.getConnection(db, user, pass);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from categorias")) {

            while(rs.next()) {
                System.out.println(rs.getInt("categoria") + " - " +
                                   rs.getString("titulo") + " - " +
                                   rs.getInt("salario") + " euros - " +
                                   rs.getInt("trienio") + " euros.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void apartado1Printf() {
        try (Connection conn = DriverManager.getConnection(db, user, pass);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from categorias")) {

            System.out.printf("\n%3s %-20s %10s %9s\n", "ID", "Título", "Salario", "Trienio");
            System.out.println("-".repeat(45));

            while(rs.next()) {
                System.out.printf("%3d %-20s %10d %9d\n",
                                  rs.getInt("categoria"),
                                  rs.getString("titulo"),
                                  rs.getInt("salario"),
                                  rs.getInt("trienio"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        apartado1();
        apartado1Printf();
    }
}
