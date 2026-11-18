/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;
import java.sql.*;
/**class konfigurasi yang bertugas membuka, menyimpan, dan 
 * mengelola jalur koneksi antara aplikasi Java dengan server database (MySQL) 
 * menggunakan JDBC (Java Database Connectivity).
 *
 * @author Asus
 */
public class DBConnector {
    private Connection Connect;
    private Statement Sttment;

    public DBConnector() { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_pbo", "root", "");
            Sttment = Connect.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection Failed : " + ex.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + ex.getMessage());
        }
    }
    
    public boolean InsertSQL(String SQLStatement){
        boolean Success;
        try {
            Success = Sttment.executeUpdate(SQLStatement) > 0;
        } catch (SQLException ex) {
            System.out.println("Insert Failed : " + ex.getMessage());
            return false;
        }
        return Success;
    }
    
    public boolean DeleteSQL(String SQLStatement){
        boolean Success;
        try {
            Success = Sttment.executeUpdate(SQLStatement) > 0;     
        } catch (SQLException ex) {
            System.out.println("Delete Failed : " + ex.getMessage());
            return false;
        }
        return Success;
    }
    
    public ResultSet SelectSQL(String SQLStatement){
        ResultSet RS = null;
        try {
            RS = Sttment.executeQuery(SQLStatement);
        } catch (SQLException ex) {
            System.out.println("Select Failed : " + ex.getMessage());
        }
        return RS;        
    }
    
    public boolean UpdateSQL(String SQLStatement){
        boolean Success;
        try {
            Success = Sttment.executeUpdate(SQLStatement) > 0;
        } catch (SQLException ex) {
            System.out.println("Update Failed : " + ex.getMessage());
            return false;
        }
        return Success;
    }
}

