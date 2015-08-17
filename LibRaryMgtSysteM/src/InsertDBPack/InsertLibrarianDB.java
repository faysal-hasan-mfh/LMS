/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertDBPack;

import DatabasePack.GetPack.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class InsertLibrarianDB {
    
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB(String officerId, String name, String email, String address, String contact1, String contact2, String password){
    
    
       GetDataFromLibrarianDB objgdfd=new GetDataFromLibrarianDB();
        
        int lastID= objgdfd.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
            c.setAutoCommit(false);
            System.out.println("Opened Librarian..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO LibrarianTab (ID,LIBOFFICERID,NAME,EMAIL,ADDRESS,CONTACT1,CONTACT2,PASSWORD) " +
                   "VALUES (?,?,?,?,?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,officerId);
             pst.setString(3,name);
             pst.setString(4,email);
             pst.setString(5,address);
             pst.setString(6,contact1);
             pst.setString(7,contact2);
             pst.setString(8,password);
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
            System.exit(0);
    }
        
        
    System.out.println("Records created successfully");
    JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public static void main(String arg[])
    {
   
    InsertLibrarianDB obj=new InsertLibrarianDB();
    obj.InsertToDB("NSTU-CSTE-101","A", "jk@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
    obj.InsertToDB("NSTU-CSTE-102","B", "jh@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
      obj.InsertToDB("NSTU-CSTE-101","C", "jk@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
    obj.InsertToDB("NSTU-CSTE-102","D", "jh@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
      obj.InsertToDB("NSTU-CSTE-101","E", "jk@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
    obj.InsertToDB("NSTU-CSTE-102","F", "jh@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
      obj.InsertToDB("NSTU-CSTE-101","G", "jk@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
    obj.InsertToDB("NSTU-CSTE-102","H", "jh@gmail.com","sonapur, Noakhali","0191300000","01715000000","123456");
    }
     
}
