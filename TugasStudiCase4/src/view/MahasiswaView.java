package view;

import model.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MahasiswaView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton, updateButton, deleteButton;

    public MahasiswaView(List<Mahasiswa> mahasiswaList) {
        setTitle("Manajemen Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabel
        tableModel = new DefaultTableModel(new Object[]{"NIM", "Nama", "Jurusan", "Email", "Alamat"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Tambah");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Hapus");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load data
        for (Mahasiswa m : mahasiswaList) {
            tableModel.addRow(new Object[]{m.getNim(), m.getNama(), m.getJurusan(), m.getEmail(), m.getAlamat()});
        }
    }

    public void addMahasiswaToTable(Mahasiswa mahasiswa) {
        tableModel.addRow(new Object[]{mahasiswa.getNim(), mahasiswa.getNama(), mahasiswa.getJurusan(),
                mahasiswa.getEmail(), mahasiswa.getAlamat()});
    }

    public void updateMahasiswaInTable(int rowIndex, Mahasiswa mahasiswa) {
        tableModel.setValueAt(mahasiswa.getNama(), rowIndex, 1);
        tableModel.setValueAt(mahasiswa.getJurusan(), rowIndex, 2);
        tableModel.setValueAt(mahasiswa.getEmail(), rowIndex, 3);
        tableModel.setValueAt(mahasiswa.getAlamat(), rowIndex, 4);
    }

    public void removeMahasiswaFromTable(int rowIndex) {
        tableModel.removeRow(rowIndex);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Mahasiswa getMahasiswaFromTable(int rowIndex) {
        return new Mahasiswa(
                (String) tableModel.getValueAt(rowIndex, 0),
                (String) tableModel.getValueAt(rowIndex, 1),
                (String) tableModel.getValueAt(rowIndex, 2),
                (String) tableModel.getValueAt(rowIndex, 3),
                (String) tableModel.getValueAt(rowIndex, 4)
        );
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void setDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}