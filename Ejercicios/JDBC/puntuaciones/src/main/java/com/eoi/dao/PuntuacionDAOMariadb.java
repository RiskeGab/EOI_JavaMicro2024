package com.eoi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eoi.entidades.Puntuacion;

public class PuntuacionDAOMariadb implements PuntuacionDAO {
    Connection conn;
    public PuntuacionDAOMariadb(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Puntuacion> getPuntuaciones() {
        List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from puntuacion");

            while(rs.next()) {
                // Product(int id, String referencia, String nombre, double precio, int categoria) {
                    puntuaciones.add(new Puntuacion(rs.getInt("id"), 
                                        rs.getString("jugador"),
                                        rs.getInt("puntuacion")));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return puntuaciones;
    }
    
}
