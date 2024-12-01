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
public class MySqlConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pp2_biodata";
    private static final String DB_USER = "root";
    private static final String DB_PASS = ""; // Sesuaikan dengan password MySQL Anda

    private static Connection connection;

    // Singleton Pattern untuk menghindari koneksi berganda
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}