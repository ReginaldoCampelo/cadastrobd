/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author regin
 */
public class ConectorBD {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "seuUsuario";
    private static final String PASSWORD = "suaSenha";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static PreparedStatement getPreparedStatement(String sql, Connection conn) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public static ResultSet getSelect(String sql, Connection conn) throws SQLException {
        return conn.createStatement().executeQuery(sql);
    }

    public static void close(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        if (stmt != null && !stmt.isClosed()) {
            stmt.close();
        }
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    
    }
}
