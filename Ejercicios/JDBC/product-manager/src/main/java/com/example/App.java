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
    private static final String db = "jdbc:mariadb://localhost:3306/product-manager";
    private static final String user = "root";
    private static final String pass = "";

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Listar las categorías
     */
    public static void apartado4(Connection conn) throws SQLException {
        System.out.print("Nombre categoría: ");
        String nombreCat = sc.nextLine();

        System.out.print("Referencia producto: ");
        String referencia = sc.nextLine();
        
        System.out.print("Nombre producto: ");
        String nombreProd = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        boolean currentAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false); // Empezamos una transacción
        try {
            PreparedStatement st = conn.prepareStatement("insert into category(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, nombreCat);
            st.executeUpdate();

            ResultSet keys = st.getGeneratedKeys();
            keys.first();
            int idCategoria = keys.getInt(1);

            PreparedStatement st2 = conn.prepareStatement("insert into product(reference, name, price, category) values(?, ?, ? ,?)");
            st2.setString(1, referencia);
            st2.setString(2, nombreProd);
            st2.setDouble(3, precio);
            st2.setInt(4, idCategoria);
            st2.executeUpdate();
            conn.commit(); // Confirmar transacción
        } catch (SQLException e) {
            conn.rollback(); // CAncelar transacción
        } finally {
            conn.setAutoCommit(currentAutoCommit); // Autocommit como estaba antes
        }
    }

    public static void listarCategorias(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        var rs = st.executeQuery("select * from category");
        while(rs.next()) {
            System.out.printf("%d - %s\n", rs.getInt(1), rs.getString(2));
        }
    }

    public static void apartado5(Connection conn) throws SQLException {
        listarCategorias(conn);
        System.out.print("Elige una categoría: ");
        int id = sc.nextInt();

        boolean currentAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false); // Empezamos una transacción
        try {
            PreparedStatement st = conn.prepareStatement("delete from product where category = ?");
            st.setInt(1, id);
            st.executeUpdate();
        
            PreparedStatement st2 = conn.prepareStatement("delete from category where id = ?");
            st2.setInt(1, id);
            st2.executeUpdate();

            conn.commit(); // Confirmar transacción
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            conn.rollback(); // CAncelar transacción
        } finally {
            conn.setAutoCommit(currentAutoCommit); // Autocommit como estaba antes
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            // apartado4(conn);
            apartado5(conn);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
