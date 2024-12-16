package model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;
    private String email;
    private String alamat;

    public Mahasiswa(String nim, String nama, String jurusan, String email, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.email = email;
        this.alamat = alamat;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}