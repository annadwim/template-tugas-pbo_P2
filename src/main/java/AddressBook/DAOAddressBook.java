/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Kelas DAO (Data Access Object) : pola desain (design pattern) dalam pemrograman yang bertugas khusus sebagai jembatan antara aplikasi dan database.
 * @author Asus
 */
public class DAOAddressBook {

    private final DBConnector DbConnect;

    public DAOAddressBook() {
        DbConnect = new DBConnector();
    }

    public Buku_Alamat getAddrsBookData(int id_kontak) {
        Buku_Alamat EAdrsBook = null;
        ResultSet RSet = DbConnect.SelectSQL("SELECT * FROM tb_bukualamat WHERE id = '" + id_kontak + "'");
        try {
            if (RSet!=null && RSet.next()) {
                EAdrsBook = new Buku_Alamat(
                        RSet.getInt("id_kontak"),
                        RSet.getString("nama"),
                        RSet.getString("alamat"),
                        RSet.getString("no_telp"),
                        RSet.getString("email")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Select Data Failed : " + ex.getMessage());
        }
        return EAdrsBook;
    }

    public Buku_Alamat[] getTableAddressBook() {
        ArrayList<Buku_Alamat> list = new ArrayList<>(); 
     
        ResultSet RSet = DbConnect.SelectSQL("SELECT * FROM tb_bukualamat");
        try {
            if (RSet != null) {
                while(RSet.next()){
                    list.add(new Buku_Alamat(
                            RSet.getInt("id_kontak"),
                            RSet.getString("nama"),
                            RSet.getString("alamat"),
                            RSet.getString("no_telp"),
                            RSet.getString("email")
                    ));                        
                } 
            }

        } catch (SQLException ex) {
            System.out.println("Load Tabel Address Book  ! : " + ex.getMessage());
        }
        return list.toArray(new Buku_Alamat[0]);
    }
    
    public boolean InsertAddrsBookData(Buku_Alamat EAdrsBook) {
        return DbConnect.InsertSQL("INSERT INTO tb_bukualamat (nama,alamat,no_telp,email) "
                + "VALUES ('" + EAdrsBook.getNama() + "','"
                + EAdrsBook.getAlamat() + "','"
                + EAdrsBook.getNomorTelepon() + "','"
                + EAdrsBook.getEmail() + "')");
    }

    public boolean DeleteAkunData(int id_kontak) {
        return DbConnect.DeleteSQL("DELETE FROM tb_bukualamat WHERE id_kontak = '" + id_kontak + "'");
    }
    
    public boolean UpdateAkunData(Buku_Alamat EAdrsBook){
        return DbConnect.UpdateSQL("UPDATE tb_bukualamat SET "
                + "nama = '" + EAdrsBook.getNama().replace("'", "''") + "', "
                + "alamat = '" + EAdrsBook.getAlamat().replace("'", "''") + "', "
                + "no_telp = '" + EAdrsBook.getNomorTelepon().replace("'", "''") + "', "
                + "email = '" + EAdrsBook.getEmail().replace("'", "''") + "' "
                + "WHERE id_kontak = '" + EAdrsBook.getId_kontak() + "'");
    }
}

