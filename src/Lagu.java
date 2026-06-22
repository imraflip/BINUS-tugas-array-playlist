public class Lagu {

    // Atribut dengan enkapsulasi (private)
    private String judul;
    private String artis;
    private double durasi;

    // Constructor untuk inisialisasi objek lagu
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Method getter untuk membaca nilai judul
    public String getJudul() {
        return judul;
    }

    // Method getter untuk membaca nilai artis
    public String getArtis() {
        return artis;
    }

    // Method getter untuk membaca nilai durasi
    public double getDurasi() {
        return durasi;
    }

    // Method untuk menampilkan informasi lengkap sebuah lagu
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
    }
}