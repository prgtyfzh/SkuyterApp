package com.example.skuyter.db;

public class Penyewa {
    String id_penyewa;
    String nik;
    String nama;
    String alamat;
    String telepon;

    public Penyewa() {
    }

    public Penyewa(String id_penyewa, String nik, String nama, String alamat, String telepon) {
        this.id_penyewa = id_penyewa;
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public String getId_penyewa() {
        return id_penyewa;
    }

    public void setId_penyewa(String id_penyewa) {
        this.id_penyewa = id_penyewa;
    }

    public String getNik() { return nik; }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

}
