package com.example.skuyter.db;

public class Rental {
    String id;
    String nama;
    String tanggal;
    String durasi;
    String waktu;

    public Rental() {

    }

    public Rental(String id, String nama, String tanggal, String durasi, String waktu) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.durasi = durasi;
        this.waktu = waktu;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
