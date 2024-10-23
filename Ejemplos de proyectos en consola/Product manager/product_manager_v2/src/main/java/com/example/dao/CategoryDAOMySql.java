package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.entidades.Category;

public class CategoryDAOMySql implements CategoryDAO {
    private static final String db = "jdbc:mariadb://localhost:3306/product-manager";
    private static final String user = "root";
    private static final String pass = "";

    @Override
    public List<Category> getCategorias() {
        List<Category> categorias = new ArrayList<Category>();

        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from category");

            while(rs.next()) {
                categorias.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return categorias;
    }

    @Override
    public void insertCategoria(Category categoria) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement st = conn.prepareStatement("insert into category(name) values(?)");
            st.setString(1, categoria.getNombre());
            st.executeUpdate();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
    }

    @Override
    public void deleteCategoria(int id) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement st = conn.prepareStatement("delete from category where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
    }

    @Override
    public void updateCategoria(Category categoria) {
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement st = conn.prepareStatement("update category set name = ? where id = ?");
            st.setString(1, categoria.getNombre());
            st.setInt(2, categoria.getId());
            st.executeUpdate();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
    }
}
