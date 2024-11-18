package com.toko.model;


public class MasterPelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String alamat;

    // Konstruktor
    public MasterPelanggan(String idPelanggan, String namaPelanggan, String alamat) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
    }

    // Getter dan Setter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    // Method untuk menampilkan informasi pelanggan
    public void tampilPelanggan() {
        System.out.println("ID Pelanggan: " + idPelanggan);
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Alamat: " + alamat);
    }
}
