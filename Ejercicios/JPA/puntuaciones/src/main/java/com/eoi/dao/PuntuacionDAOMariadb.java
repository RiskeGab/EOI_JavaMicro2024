package com.eoi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    @Override
    public Puntuacion insertPuntuacion(Puntuacion puntuacion) {
        String sql = "insert into puntuacion (jugador, puntuacion) values (?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, puntuacion.getJugador());
            st.setInt(2, puntuacion.getPuntuacion());
            st.executeUpdate();

            ResultSet keys = st.getGeneratedKeys();
            keys.first();
            puntuacion.setId(keys.getInt(1));
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return puntuacion;
    }

    @Override
    public void updatePuntuacion(int id, int puntuacion) {
        String sql = "update puntuacion set puntuacion = ? where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, puntuacion);
            st.setInt(2, id);
            st.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deletePuntuacion(int id) {
        String sql = "delete from puntuacion where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
