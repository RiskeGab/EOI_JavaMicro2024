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
public class App 
{
    private static final String db = "jdbc:mariadb://localhost:3306/product-manager";
    private static final String user = "root";
    private static final String pass = "";

    public static void main( String[] args )
    {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from category");

            System.out.printf("%5s %-40s\n", "ID", "NOMBRE");
            while(rs.next()) {
                System.out.printf("%5d %-40s\n", 
                                rs.getInt("id"), 
                                rs.getString("name"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println( "Hello World!" );
    }
}
