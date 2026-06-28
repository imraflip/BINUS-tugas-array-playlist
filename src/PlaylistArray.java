/*
Anggota Kelompok 2:
- Irma Suci Anggraini (2902781080)
- Rafli Permana Putra (2902791466)
- Diza Yuan Aditia (2902794272)
- Mukhammad Syaifudin Adn (2902774951)
- Suci Indah Alfianqulbi (2902773324)
*/

import java.util.Scanner;

public class PlaylistArray {

    // Array statis untuk menyimpan kumpulan objek Lagu (maksimal 10 lagu)
    static Lagu[] playlist = new Lagu[10];
    static int jumlahLagu = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu;

        // Loop utama aplikasi
        do {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi"); 
            System.out.println("6. Keluar");
            System.out.print("Pilihan : ");

            menu = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (menu) {
                case 1:
                    tampilkanSemuaLagu();
                    break;
                case 2:
                    tambahLagu(input);
                    break;
                case 3:
                    hapusLagu(input);
                    break;
                case 4:
                    cariLagu(input);
                    break;
                case 5:
                    urutkanLaguBerdasarkanDurasi();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 6);

        input.close();
    }

    // Method untuk menampilkan seluruh daftar lagu di playlist (Traversal)
    static void tampilkanSemuaLagu() {
        System.out.println("\n=== Daftar Semua Lagu ===");

        // Cek apakah playlist masih kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist saat ini masih kosong.");
            return;
        }

        // Perulangan menelusuri seluruh objek lagu di array
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println((i + 1) + ". ");
            playlist[i].tampilkanInfo();
            System.out.println("-----------------------");
        }
    }

    // Method untuk menambah lagu baru ke dalam array playlist (Insertion)
    static void tambahLagu(Scanner input) {

        // Cek apakah array playlist sudah penuh
        if (jumlahLagu >= playlist.length) {
            System.out.println("Playlist penuh!");
            return;
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
        jumlahLagu++; // Update jumlah lagu

        System.out.println("Lagu berhasil ditambahkan!");
    }

    // Method untuk menghapus lagu berdasarkan judul (Deletion)
    static void hapusLagu(Scanner input) {
        System.out.println("\n=== Hapus Lagu ===");

        // Cek apakah playlist masih kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus : ");
        String judulDicari = input.nextLine();

        int indexDitemukan = -1;

        // Linear search untuk menemukan posisi lagu yang akan dihapus
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulDicari)) {
                indexDitemukan = i;
                break; // Hentikan pencarian jika sudah ketemu
            }
        }

        // Jika lagu tidak ditemukan
        if (indexDitemukan == -1) {
            System.out.println("Maaf, lagu dengan judul '" + judulDicari + "' tidak ditemukan.");
            return;
        }

        // Geser semua elemen setelah posisi yang dihapus ke kiri
        // agar tidak ada celah kosong di tengah array
        for (int i = indexDitemukan; i < jumlahLagu - 1; i++) {
            playlist[i] = playlist[i + 1];
        }

        // Kosongkan slot terakhir dan kurangi jumlah lagu
        playlist[jumlahLagu - 1] = null;
        jumlahLagu--;

        System.out.println("Lagu '" + judulDicari + "' berhasil dihapus!");
    }

    // Method untuk mencari lagu berdasarkan judul menggunakan linear search (Searching)
    static void cariLagu(Scanner input) {
        System.out.println("\n=== Cari Lagu ===");

        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari : ");
        String judulDicari = input.nextLine();
        boolean ditemukan = false;

        // Penelusuran array playlist (linear search)
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judulDicari)) {
                System.out.println("Lagu berhasil ditemukan!");
                playlist[i].tampilkanInfo();
                ditemukan = true;
                break; // Hentikan pencarian jika lagu sudah ketemu
            }
        }

        // Jika perulangan selesai dan lagu tidak ditemukan
        if (!ditemukan) {
            System.out.println("Maaf, lagu dengan judul '" + judulDicari + "' tidak ditemukan.");
        }
    }

    // Method mengurutkan lagu berdasarkan durasi secara ascending (Bubble Sort)
    static void urutkanLaguBerdasarkanDurasi() {
        System.out.println("\n=== Urutkan Lagu Berdasarkan Durasi ===");

        // Cek apakah playlist kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa diurutkan.");
            return;
        }

        // Tampilkan kondisi SEBELUM diurutkan
        System.out.println("\n--- SEBELUM diurutkan ---");
        tampilkanSemuaLagu();

        // Proses Bubble Sort
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - 1 - i; j++) {
                // Tukar posisi jika durasi kiri lebih besar dari kanan
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];          // simpan lagu kiri di penampung sementara
                    playlist[j] = playlist[j + 1];    // pindahkan lagu kanan ke kiri
                    playlist[j + 1] = temp;           // pindahkan lagu simpanan ke kanan
                }
            }
        }

        // Tampilkan kondisi SESUDAH diurutkan
        System.out.println("\n--- SESUDAH diurutkan (durasi ascending) ---");
        tampilkanSemuaLagu();
    }
}