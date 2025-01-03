import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Game {
    String nama;
    int stock;
    int price;

    public Game(String nama, int stock, int price) {
        this.nama = nama;
        this.stock = stock;
        this.price = price;
    }

    abstract void purchase();

    void info() {
        System.out.println("Game: " + nama + " | Stock: " + stock + " | Price: " + price);
    }
}

class digitalGame extends Game {
    public digitalGame(String nama, int stock, int price) {
        super(nama, stock, price);
    }

    @Override
    void purchase() {
        if (stock > 0) {
            stock--;
            System.out.println("Pembelian Digital Game: " + nama + " IDR " + price);
        } else {
            System.out.println("Stock untuk " + nama + " tidak tersedia");
        }
    }
}

class gameFisik extends Game {
    public gameFisik(String nama, int stock, int price) {
        super(nama, stock, price);
    }

    @Override
    void purchase() {
        if (stock > 0) {
            stock--;
            System.out.println("Pembelian Game Fisik: " + nama);
        } else {
            System.out.println("Stock untuk " + nama + " tidak tersedia");
        }
    }
}

interface Bonus {
    void addBonus(String bonus);
}

class digitalBonus extends digitalGame implements Bonus {
    private String bonusItem;

    public digitalBonus(String nama, int stock, int price) {
        super(nama, stock, price);
    }

    @Override
    public void addBonus(String bonus) {
        this.bonusItem = bonus;
        System.out.println("Bonus yang didapat: " + bonusItem);
    }

    @Override
    void purchase() {
        if (stock > 0) {
            stock--;
            System.out.println("Pembelian Game Digital: " + nama + " | Bonus: " + bonusItem);
        } else {
            System.out.println("Stock untuk " + nama + " tidak tersedia");
        }
    }
}

public class GameStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Game> games = new ArrayList<>();
        games.add(new digitalBonus("Digital Love Live Idol School Project", 5, 250999));
        games.add(new digitalBonus("Digital Gwent The Witcher", 10, 122999));
        games.add(new digitalBonus("Digital Assassin's Creed Odyssey", 20, 785999));
        games.add(new digitalBonus("Digital Hogwarts Legacy", 5, 785999));
        games.add(new digitalBonus("Digital Blatriory Mobile of the year", 7, 146000));
        games.add(new digitalBonus("Digital Ghost Of Tsushima", 4, 785999));
        games.add(new digitalBonus("Coffee Talk Tokyo", 10, 299999));
        games.add(new digitalBonus("Troublemaker 2: Beyond Dream", 10, 349999));
        games.add(new digitalBonus("Pamali: The Vengeful Mother", 7, 199999));
        games.add(new digitalBonus("Elmora", 10, 249999));
        games.add(new digitalBonus("Mirth Island", 7, 229999));
        games.add(new digitalBonus("Kidbash: Super Legend", 6, 279999));
        games.add(new gameFisik("Tekken 8 Asuka Kazama Collection", 3, 785999));
        games.add(new gameFisik("Monster Hunter World", 10, 785999));
        games.add(new gameFisik("Collector Edition Assassin's Creed Mirage", 1, 785999));
        games.add(new gameFisik("Grand Theft Auto 6", 100, 1099999));
        games.add(new gameFisik("Death Stranding 2: The Beach", 5, 799999));
        games.add(new gameFisik("Fable", 8, 699999));
        games.add(new gameFisik("Metroid Prime 4: Beyond", 12, 849999));
        games.add(new gameFisik("Borderlands 4", 14, 1099999));
        games.add(new gameFisik("Ghost of Yōtei", 74, 899999));
        games.add(new gameFisik("Marvel 1943: Rise of Hydra", 8, 1099999));
        games.add(new gameFisik("Civilization 7", 12, 1499999));
        games.add(new gameFisik("Assassin's Creed Shadows", 52, 1099999));
        games.add(new gameFisik("Kingdom Come: Deliverance 2", 42, 999999));

        System.out.println("Stock yang tersedia:");
        for (int i = 0; i < games.size(); i++) {
            System.out.print((i + 1) + ". ");
            games.get(i).info();
        }

        System.out.println("\nSilahkan pilih game yang ingin Anda beli:");
        System.out.println("Setiap Pembelian Digital Game akan mendapatkan DLC Skin Pack");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= games.size()) {
            Game selectedGame = games.get(choice - 1);

            System.out.println("Berapa banyak yang ingin Anda beli?");
            int quantity = scanner.nextInt();

            if (selectedGame.stock >= quantity) {
                int totalPrice = selectedGame.price * quantity;
                selectedGame.stock -= quantity; // Kurangi stock
                System.out.println("Pembelian berhasil:");
                System.out.println("Nama Game: " + selectedGame.nama);
                System.out.println("Jumlah yang dibeli: " + quantity);
                System.out.println("Total harga: IDR " + totalPrice);

                if (selectedGame instanceof digitalBonus) {
                    ((digitalBonus) selectedGame).addBonus("DLC Skin Pack");
                }
            } else {
                System.out.println("Stock tidak mencukupi, silahkan hubungi admin untuk melakukan Pre - Order . Tersedia: " + selectedGame.stock);
            }

            selectedGame.info();
        } else {
            System.out.println("-------.");
        }

        scanner.close();
    }
}
