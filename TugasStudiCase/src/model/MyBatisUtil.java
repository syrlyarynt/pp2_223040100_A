package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyBatisUtil {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/tugas04_studikasus";
  private static final String USER = "root";
  private static final String PASSWORD = "";

  public static void initializeDatabase() {
    try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
      String createTableQuery = "CREATE TABLE IF NOT EXISTS mahasiswa (" +
          "nim VARCHAR(10) PRIMARY KEY," +
          "nama VARCHAR(100)," +
          "jurusan VARCHAR(100)," +
          "email VARCHAR(100)," +
          "alamat TEXT)";
      connection.createStatement().execute(createTableQuery);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() throws Exception {
    try {
      // Mencoba menghubungkan ke database
      Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      System.out.println("Koneksi berhasil ke database: " + DB_URL);
      return connection;
    } catch (Exception e) {
      // Menangani error jika koneksi gagal
      System.out.println("Koneksi gagal ke database: " + DB_URL);
      e.printStackTrace();
      throw e; // lempar kembali exception agar dapat diketahui errornya
    }
  }

}