package controller;

import model.Mahasiswa;
import model.MahasiswaMapper;
import view.MahasiswaView;

import java.util.List;

public class MahasiswaController {
  private MahasiswaView view;

  public MahasiswaController(MahasiswaView view) {
    this.view = view;
  }

  public static List<Mahasiswa> getAllMahasiswa() {
    return MahasiswaMapper.getAllMahasiswa();
  }

  public void addMahasiswa(Mahasiswa mahasiswa) {
    MahasiswaMapper.insertMahasiswa(mahasiswa);
    view.addMahasiswaToTable(mahasiswa);
  }

  public void updateMahasiswa(Mahasiswa mahasiswa) {
    MahasiswaMapper.updateMahasiswa(mahasiswa);
  }

  public void deleteMahasiswa(String nim) {
    MahasiswaMapper.deleteMahasiswa(nim);
  }
}