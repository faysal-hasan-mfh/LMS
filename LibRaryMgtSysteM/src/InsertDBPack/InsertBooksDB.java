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
public class InsertBooksDB {
    
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB(String booksID, String booksTitle, String booksGroup, String booksSerial, String isbnno, String author, int availability){
    
    
      GetDataFromBooksDB getdatabook=new GetDataFromBooksDB();
        
        int lastID= getdatabook.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Books.db");
            c.setAutoCommit(false);
          //  System.out.println("Opened Books..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO BooksTab (ID,BOOKSID,BOOKSTITLE,BOOKSGROUP,BOOKSSERIAL,ISBNNO,AUTHOR,AVAILABILITY) " +
                   "VALUES (?,?,?,?,?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,booksID);
             pst.setString(3,booksTitle);
             pst.setString(4,booksGroup);
             pst.setString(5,booksSerial);
             pst.setString(6,isbnno);
             pst.setString(7, author);
             pst.setInt(8, availability);
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
            System.exit(0);
    }
        
        
    System.out.println("Books Records created successfully");
  //  JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
    }
    
    
    public static void main(String arg[])
    {
   
   InsertBooksDB obj=new InsertBooksDB();
    obj.InsertToDB("1001","Java Complete Reference", "CSTE","101","abc1021321546","Hervert Shieldt",15);
     obj.InsertToDB("B-1002","C Complete Reference", "CSTE","102","abc1021321546","Hervert Shieldt",15);
   
    }
     
}
