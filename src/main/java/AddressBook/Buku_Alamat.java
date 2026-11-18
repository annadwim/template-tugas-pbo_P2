 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;
/**
 *
 * @author Asus
 */
public class Buku_Alamat {
    private int id_kontak;
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private String email;

    public Buku_Alamat() {
       
        this.nama = "";
        this.alamat = "";
        this.nomorTelepon = "";
        this.email = "";
    }

    public Buku_Alamat(int id_kontak, String nama, String alamat, String nomorTelepon, String email) {
        this.id_kontak = id_kontak;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
    }

    public int getId_kontak() {
        return id_kontak;
    }    
    
    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setId_kontak(int id_kontak) {
        this.id_kontak = id_kontak;
    }
        
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void insertData(String nama, String alamat, String nomorTelepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
    }

 /*   public void deleteData() {
        setNama("- (Data Dihapus)");
        setAlamat("-");
        setNomorTelepon("-");
        setEmail("-");
    }

    public void showData() {
        System.out.println("Nama          : " + getNama());
        System.out.println("Alamat        : " + getAlamat());
        System.out.println("Nomor Telepon : " + getNomorTelepon());
        System.out.println("Email         : " + getEmail());
    }

    public void updateData(String nama, String alamat, String nomorTelepon, String email) {
        setNama(nama);
        setAlamat(alamat);
        setNomorTelepon(nomorTelepon);
        setEmail(email);
    }

    // Method static untuk menampilkan seluruh data dalam array BukuAlamat
    public static void showAllData(Buku_Alamat[] daftar) {
        System.out.println("\n-------------------");
        System.out.println("Data BUKU ALAMAT : ");
        System.out.println("-------------------");
        for (int i = 0; i < daftar.length; i++) {
            System.out.println((i + 1) + ".");
            if (daftar[i] != null) {
                daftar[i].showData();
            } else {
                System.out.println("(Kosong)");
            }
            System.out.println();
        }
    }
    */
}
