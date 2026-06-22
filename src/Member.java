public class Member extends User {

    // Constructor child class memanggil super() dari User
    public Member(String nama) {
        super(nama);
    }

    // Method untuk melihat seluruh daftar lagu di playlist
    public void lihatPlaylist(Lagu[] playlist, int jumlahLagu) {
        System.out.println("\n=== Daftar Lagu di Playlist ===");

        // Cek apakah playlist masih kosong
        if (jumlahLagu == 0) {
            System.out.println("Playlist saat ini masih kosong.");
            return;
        }

        // Perulangan untuk menampilkan semua objek lagu di array
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println((i + 1) + ". ");
            playlist[i].tampilkanInfo();
            System.out.println("-----------------------");
        }
    }

    // Method untuk mencari lagu di dalam array berdasarkan judul (tidak case sensitive)
    public void cariLagu(Lagu[] playlist, int jumlahLagu, String judulDicari) {
        System.out.println("\n=== Cari Lagu ===");
        boolean ditemukan = false;

        // Penelusuran array playlist
        for (int i = 0; i < jumlahLagu; i++) {
            // Menerapkan enkapsulasi melalui getter getJudul()
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

    // Method tambahan sesuai instruksi untuk menghitung rata-rata durasi lagu
    public void hitungRataRata(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, rata-rata durasi: 0 menit.");
            return;
        }

        double total = 0;
        for (int i = 0; i < jumlahLagu; i++) {
            total += playlist[i].getDurasi();
        }

        System.out.println("\nRata-rata durasi lagu di playlist: " + (total / jumlahLagu) + " menit");
    }

    // Override polimorfisme untuk role Member
    @Override
    public void tampilkanAkses() {
        System.out.println("--- Akses: Member Playlist (Mode Baca, Cari & Rata-rata) ---");
    }
}