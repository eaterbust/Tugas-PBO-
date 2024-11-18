package com.toko.transaksi;

import com.toko.model.MasterProduk;
import com.toko.model.MasterPelanggan;

public class TransaksiPenjualan {
    private String idTransaksi;
    private MasterProduk produk;
    private MasterPelanggan pelanggan;
    private int jumlah;
    private double totalHarga;

    // Konstruktor dengan parameter
    public TransaksiPenjualan(String idTransaksi, MasterProduk produk, MasterPelanggan pelanggan, int jumlah) {
        this.idTransaksi = idTransaksi;
        this.produk = produk;
        this.pelanggan = pelanggan;
        this.jumlah = jumlah;
        this.totalHarga = hitungTotal();
    }

    // Metode hitungTotal
    public double hitungTotal() {
        return produk.getHargaProduk() * jumlah;
    }

    // Metode tampilTransaksi
    public void tampilTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Produk: " + produk.getNamaProduk());
        System.out.println("Pelanggan: " + pelanggan.getNamaPelanggan());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: " + totalHarga);
    }
}
