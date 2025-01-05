import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produk {
    private String idProduk;
    private String nama;
    private int harga;
    private int stok;

    public Produk(String idProduk, String nama, int harga, int stok) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            this.stok -= jumlah;
            return true;
        } else {
            return false;
        }
    }

    public void tampilkanDetail() {
        System.out.printf("%-5s %-40s %-10d %-10d\n", idProduk, nama, harga, stok);
    }
}

class Transaksi {
    private String idTransaksi;
    private Produk produk;
    private int jumlah;

    public Transaksi(String idTransaksi, Produk produk, int jumlah) {
        this.idTransaksi = idTransaksi;
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void tampilkanDetail() {
        int totalHarga = jumlah * produk.getHarga();
        System.out.printf("%-10s %-40s %-10d %-10d\n", idTransaksi, produk.getNama(), jumlah, totalHarga);
    }
}

class Toko {
    private List<Produk> daftarProduk;
    private List<Transaksi> daftarTransaksi;
    private int idTransaksiCounter = 1001;

    public Toko() {
        daftarProduk = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();
    }

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public void tampilkanProduk() {
        System.out.printf("%-5s %-40s %-10s %-10s\n", "ID", "Nama Produk", "Harga", "Stok");
        System.out.println("=============================================================");
        for (Produk produk : daftarProduk) {
            produk.tampilkanDetail();
        }
    }

    public void tampilkanTransaksi() {
        System.out.printf("%-10s %-40s %-10s %-10s\n", "ID Transaksi", "Nama Produk", "Jumlah", "Total Harga");
        System.out.println("=============================================================");
        for (Transaksi transaksi : daftarTransaksi) {
            transaksi.tampilkanDetail();
        }
    }

    public void lakukanTransaksi(String idProduk, int jumlah) {
        for (Produk produk : daftarProduk) {
            if (produk.getIdProduk().equals(idProduk)) {
                if (produk.kurangiStok(jumlah)) {
                    String idTransaksi = "T" + idTransaksiCounter++;
                    Transaksi transaksi = new Transaksi(idTransaksi, produk, jumlah);
                    daftarTransaksi.add(transaksi);
                    System.out.println("Transaksi berhasil!");
                    transaksi.tampilkanDetail();
                } else {
                    System.out.println("Stok tidak mencukupi untuk produk ini.");
                }
                return;
            }
        }
        System.out.println("Produk dengan ID " + idProduk + " tidak ditemukan.");
    }
}

public class GameStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Toko toko = new Toko();

        // Menambahkan produk
        toko.tambahProduk(new Produk("P001", "Digital Love Live Idol School Project", 250999, 5));
        toko.tambahProduk(new Produk("P002", "Digital Gwent The Witcher", 122999, 10));
        toko.tambahProduk(new Produk("P003", "Digital Assassin's Creed Odyssey", 785999, 20));
        toko.tambahProduk(new Produk("P004", "Digital Hogwarts Legacy", 785999, 5));
        toko.tambahProduk(new Produk("P005", "Digital Blatriory Mobile of the year", 146000, 7));
        toko.tambahProduk(new Produk("P006", "Digital Ghost Of Tsushima", 785999, 4));
        toko.tambahProduk(new Produk("P007", "Coffee Talk Tokyo", 299999, 10));
        toko.tambahProduk(new Produk("P008", "Troublemaker 2: Beyond Dream", 349999, 10));
        toko.tambahProduk(new Produk("P009", "Pamali: The Vengeful Mother", 199999, 7));
        toko.tambahProduk(new Produk("P010", "Elmora", 249999, 10));

        System.out.println("========================================================");
        System.out.println("                SELAMAT BERBELANJA DI TOKO GAME S5C");
        System.out.println("========================================================");

        boolean running = true;
        while (running) {
            System.out.println("\nGAME YANG TERSEDIA:");
            toko.tampilkanProduk();

            System.out.println("\nMasukkan ID produk yang ingin dibeli (atau ketik 'exit' untuk keluar):");
            String idProduk = scanner.nextLine();

            if (idProduk.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }

            System.out.println("Masukkan jumlah yang ingin dibeli:");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            toko.lakukanTransaksi(idProduk, jumlah);

            System.out.println("\nDaftar transaksi yang telah dilakukan:");
            toko.tampilkanTransaksi();
        }

        System.out.println("Terima kasih telah berbelanja di Toko Game S5C!");
        scanner.close();
    }
}