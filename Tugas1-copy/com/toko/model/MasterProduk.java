package com.toko.model;


public class MasterProduk {
    private String idProduk;
    private String namaProduk;
    private double hargaProduk;

    // Konstruktor
public MasterProduk(String idProduk, String namaProduk, double hargaProduk) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
    }

    // Getter dan Setter
    public String getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHargaProduk() {
        return hargaProduk;
    }

    // Method untuk menampilkan informasi produk
    public void tampilProduk() {
        System.out.println("ID Produk: " + idProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga Produk: Rp " + hargaProduk);
    }
}
