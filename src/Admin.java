import java.util.Scanner;

public class Admin extends User {

    // Constructor child class memanggil super() dari User
    public Admin(String nama) {
        super(nama);
    }

    // Method untuk menambah lagu baru ke dalam array playlist (Insertion)
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

    // Method untuk menampilkan seluruh daftar lagu di playlist (Traversal)
    public void tampilkanSemuaLagu(Lagu[] playlist, int jumlahLagu) {
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

    // Method untuk menghapus lagu berdasarkan judul (Deletion)
    public int hapusLagu(Lagu[] playlist, int jumlahLagu, Scanner input) {
        System.out.println("\n=== Hapus Lagu ===");

        // Cek apakah playlist masih kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa dihapus.");
            return jumlahLagu;
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
            return jumlahLagu;
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

        return jumlahLagu; // Update jumlah lagu
    }

    // Method untuk mengurutkan lagu berdasarkan durasi secara ascending (Bubble Sort)
    public void urutkanLaguBerdasarkanDurasi(Lagu[] playlist, int jumlahLagu) {
        System.out.println("\n=== Urutkan Lagu Berdasarkan Durasi ===");

        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa diurutkan.");
            return;
        }

        // Tampilkan kondisi SEBELUM diurutkan
        System.out.println("\n--- Sebelum Diurutkan ---");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println((i + 1) + ". " + playlist[i].getJudul()
                    + " (" + playlist[i].getDurasi() + " menit)");
        }

        // Algoritma Bubble Sort (ascending berdasarkan durasi)
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - 1 - i; j++) {
                // Bandingkan durasi dua lagu yang bersebelahan
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Tukar posisi jika durasi kiri lebih besar
                    Lagu sementara = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = sementara;
                }
            }
        }

        // Tampilkan kondisi SESUDAH diurutkan
        System.out.println("\n--- Sesudah Diurutkan (Durasi Terkecil ke Terbesar) ---");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println((i + 1) + ". " + playlist[i].getJudul()
                    + " (" + playlist[i].getDurasi() + " menit)");
        }
    }

    // Override polimorfisme untuk role Admin
    @Override
    public void tampilkanAkses() {
        System.out.println("--- Akses: Admin Playlist (Wewenang Penuh) ---");
    }
}