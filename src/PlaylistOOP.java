/*
Anggota Kelompok 2:
- Irma Suci Anggraini (2902781080)
- Rafli Permana Putra (2902791466)
- Diza Yuan Aditia (2902794272)
- Mukhammad Syaifudin Adn (2902774951)
- Suci Indah Alfianqulbi (2902773324)
*/

import java.util.Scanner;

public class PlaylistOOP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array untuk menyimpan kumpulan objek Lagu (maksimal 10 lagu)
        Lagu[] playlist = new Lagu[10];
        int jumlahLagu = 0;

        // Deklarasi objek role
        Admin admin = new Admin("Admin");
        Member member = new Member("Member");

        int roleMenu;

        // Loop utama aplikasi (Pemilihan Role)
        do {
            System.out.println("\n===== SISTEM PLAYLIST MUSIK =====");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Member");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");

            roleMenu = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (roleMenu) {
                case 1:
                    // Polymorphism: Menjalankan tampilkanAkses versi Admin
                    System.out.println();
                    admin.tampilkanAkses();
                    int adminMenu;

                    do {
                        System.out.println("\n=== MENU ADMIN ===");
                        System.out.println("1. Tampilkan Semua Lagu");
                        System.out.println("2. Tambah Lagu");
                        System.out.println("3. Hapus Lagu Berdasarkan Judul");
                        System.out.println("4. Urutkan Lagu Berdasarkan Durasi");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilihan : ");
                        adminMenu = input.nextInt();
                        input.nextLine();

                        switch (adminMenu) {
                            case 1:
                                admin.tampilkanSemuaLagu(playlist, jumlahLagu);
                                break;
                            case 2:
                                jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, input);
                                break;
                            case 3:
                                jumlahLagu = admin.hapusLagu(playlist, jumlahLagu, input);
                                break;
                            case 4:
                                admin.urutkanLaguBerdasarkanDurasi(playlist, jumlahLagu);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Menu tidak tersedia.");
                        }
                    } while (adminMenu != 0);
                    break;

                case 2:
                    // Polymorphism: Menjalankan tampilkanAkses versi Member
                    System.out.println();
                    member.tampilkanAkses();
                    int memberMenu;

                    do {
                        System.out.println("\n=== MENU MEMBER ===");
                        System.out.println("1. Lihat Playlist");
                        System.out.println("2. Cari Lagu");
                        System.out.println("3. Hitung Rata-rata Durasi");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilihan : ");
                        memberMenu = input.nextInt();
                        input.nextLine();

                        switch (memberMenu) {
                            case 1:
                                member.lihatPlaylist(playlist, jumlahLagu);
                                break;
                            case 2:
                                System.out.print("\nMasukkan judul lagu yang dicari : ");
                                String judul = input.nextLine();
                                member.cariLagu(playlist, jumlahLagu, judul);
                                break;
                            case 3:
                                member.hitungRataRata(playlist, jumlahLagu);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Menu tidak tersedia.");
                        }
                    } while (memberMenu != 0);
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (roleMenu != 0);

        input.close();
    }
}