import java.util.Scanner;

public class Admin extends User {

    // Constructor child class memanggil super() dari User
    public Admin(String nama) {
        super(nama);
    }

    // Method untuk menambah lagu baru ke dalam array playlist
    public int tambahLagu(Lagu[] playlist, int jumlahLagu, Scanner input) {

        // Cek apakah array playlist sudah penuh
        if (jumlahLagu >= playlist.length) {
            System.out.println("Playlist penuh!");
            return jumlahLagu;
        }

        // Jika belum penuh, ambil input lagu baru
        System.out.println("\n=== Tambah Lagu ===");
        System.out.print("Judul Lagu : ");
        String judul = input.nextLine();

        System.out.print("Artis      : ");
        String artis = input.nextLine();

        System.out.print("Durasi     : ");
        double durasi = input.nextDouble();
        input.nextLine(); // Membersihkan buffer

        // Buat objek lagu baru dan simpan ke array
        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);

        System.out.println("Lagu berhasil ditambahkan!");

        return jumlahLagu + 1; // Update jumlah lagu
    }

    // Override polimorfisme untuk role Admin
    @Override
    public void tampilkanAkses() {
        System.out.println("--- Akses: Admin Playlist (Wewenang Penuh) ---");
    }
}