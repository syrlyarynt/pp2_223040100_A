package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaMapper {

  public static List<Mahasiswa> getAllMahasiswa() {
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    try (Connection connection = MyBatisUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM mahasiswa")) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        mahasiswaList.add(new Mahasiswa(
            resultSet.getString("nim"),
            resultSet.getString("nama"),
            resultSet.getString("jurusan"),
            resultSet.getString("email"),
            resultSet.getString("alamat")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mahasiswaList;
  }

  public static void insertMahasiswa(Mahasiswa mahasiswa) {
    try (Connection connection = MyBatisUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO mahasiswa (nim, nama, jurusan, email, alamat) VALUES (?, ?, ?, ?, ?)")) {
      statement.setString(1, mahasiswa.getNim());
      statement.setString(2, mahasiswa.getNama());
      statement.setString(3, mahasiswa.getJurusan());
      statement.setString(4, mahasiswa.getEmail());
      statement.setString(5, mahasiswa.getAlamat());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void updateMahasiswa(Mahasiswa mahasiswa) {
    try (Connection connection = MyBatisUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE mahasiswa SET nama = ?, jurusan = ?, email = ?, alamat = ? WHERE nim = ?")) {
      statement.setString(1, mahasiswa.getNama());
      statement.setString(2, mahasiswa.getJurusan());
      statement.setString(3, mahasiswa.getEmail());
      statement.setString(4, mahasiswa.getAlamat());
      statement.setString(5, mahasiswa.getNim());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deleteMahasiswa(String nim) {
    try (Connection connection = MyBatisUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM mahasiswa WHERE nim = ?")) {
      statement.setString(1, nim);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}