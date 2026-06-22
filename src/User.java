public class User {

    // Atribut protected agar dapat diwariskan ke class turunannya
    protected String nama;

    // Constructor parent class
    public User(String nama) {
        this.nama = nama;
    }

    // Method polimorfisme yang diminta instruksi
    public void tampilkanAkses() {
        System.out.println("User memiliki akses dasar.");
    }
}