import controller.MahasiswaController;
import model.Mahasiswa;
import model.MyBatisUtil;
import model.MahasiswaMapper;
import view.MahasiswaView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi Database
        MyBatisUtil.initializeDatabase();

        // Model
        List<Mahasiswa> mahasiswaList = MahasiswaMapper.getAllMahasiswa();

        // View
        MahasiswaView view = new MahasiswaView(mahasiswaList);

        // Controller
        MahasiswaController controller = new MahasiswaController(view);

        // Listener untuk tombol-tombol
        // Listener untuk tombol Add (Menambah Data)
view.setAddButtonListener(e -> {
    String nim = JOptionPane.showInputDialog(view, "Masukkan NIM:");
    String nama = JOptionPane.showInputDialog(view, "Masukkan Nama:");
    String jurusan = JOptionPane.showInputDialog(view, "Masukkan Jurusan:");
    String email = JOptionPane.showInputDialog(view, "Masukkan Email:");
    String alamat = JOptionPane.showInputDialog(view, "Masukkan Alamat:");

    if (nim != null && nama != null && jurusan != null && email != null && alamat != null) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, email, alamat);
        controller.addMahasiswa(mahasiswa);

        // Alert bahwa data berhasil ditambahkan
        JOptionPane.showMessageDialog(view, "Data Mahasiswa berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
});

// Listener untuk tombol Update (Mengupdate Data)
view.setUpdateButtonListener(e -> {
    int selectedRow = view.getSelectedRow();
    if (selectedRow >= 0) {
        Mahasiswa mahasiswa = view.getMahasiswaFromTable(selectedRow);
        String nama = JOptionPane.showInputDialog(view, "Ubah Nama:", mahasiswa.getNama());
        String jurusan = JOptionPane.showInputDialog(view, "Ubah Jurusan:", mahasiswa.getJurusan());
        String email = JOptionPane.showInputDialog(view, "Ubah Email:", mahasiswa.getEmail());
        String alamat = JOptionPane.showInputDialog(view, "Ubah Alamat:", mahasiswa.getAlamat());

        if (nama != null && jurusan != null && email != null && alamat != null) {
            mahasiswa.setNama(nama);
            mahasiswa.setJurusan(jurusan);
            mahasiswa.setEmail(email);
            mahasiswa.setAlamat(alamat);
            controller.updateMahasiswa(mahasiswa);
            view.updateMahasiswaInTable(selectedRow, mahasiswa);

            // Alert bahwa data berhasil diupdate
            JOptionPane.showMessageDialog(view, "Data Mahasiswa berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(view, "Pilih data yang ingin diupdate.");
    }
});


        view.setDeleteButtonListener(e -> {
            int selectedRow = view.getSelectedRow();
            if (selectedRow >= 0) {
                Mahasiswa mahasiswa = view.getMahasiswaFromTable(selectedRow);
                int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus mahasiswa dengan NIM " + mahasiswa.getNim() + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    controller.deleteMahasiswa(mahasiswa.getNim());
                    view.removeMahasiswaFromTable(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Pilih data yang ingin dihapus.");
            }
        });

        // Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }
}