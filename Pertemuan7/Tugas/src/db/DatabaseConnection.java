/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan7.Tugas.src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author syrly
 */
public class DatabaseConnection {
     public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Tambahkan ini
            
            // Ganti sesuai konfigurasi database Anda
            String url = "jdbc:mysql://localhost:3306/library_db";
            String username = "root";  // Sesuaikan dengan username MySQL Anda
            String password = "";      // Sesuaikan dengan password MySQL Anda
            
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found: " + e.getMessage());
        }
    }
}
