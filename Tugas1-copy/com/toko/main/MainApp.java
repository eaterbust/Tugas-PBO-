 import com.toko.model.MasterProduk;
import com.toko.model.MasterPelanggan;
import com.toko.transaksi.TransaksiPenjualan;

public class MainApp {
    public static void main(String[] args) {
        // Membuat objek produk
        MasterProduk produk1 = new MasterProduk("P001", "RTX 4060 TI ", 4698000);
        MasterProduk produk2 = new MasterProduk("P002", "Mouse Gaming", 2500000);
        MasterProduk produk3 = new MasterProduk("P003", "Ryzen 5 5600", 175400000);
        MasterProduk produk4 = new MasterProduk("P004", "Ram 16 Gb 2 X 16 3200Mhz", 726 000);
        // Membuat objek pelanggan
        MasterPelanggan pelanggan1 = new MasterPelanggan("C001", "Bibit Prio", "Jl. Merdeka No.10");

        // Membuat objek transaksi
        TransaksiPenjualan transaksi1 = new TransaksiPenjualan("T001", produk1, pelanggan1, 2);
        TransaksiPenjualan transaksi2 = new TransaksiPenjualan("T002", produk3, pelanggan1, 5);
        TransaksiPenjualan transaksi3 = new TransaksiPenjualan("T003", produk4, pelanggan1, 10);

        // Menampilkan detail transaksi
        System.out.println("=== Transaksi 1 ===");
        transaksi1.tampilTransaksi();
        System.out.println("\n=== Transaksi 2 ===");
        transaksi2.tampilTransaksi();
        System.out.println("\n=== Transaksi 3 ===");
        transaksi3.tampilTransaksi();
    }
}
