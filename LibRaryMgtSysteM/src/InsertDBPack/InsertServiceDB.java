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
public class InsertServiceDB {
     
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB( String libOffID,String libCardNo,String booksID, String issueDate, String returnDate)
    {
    
    
        GetDataFromServiceDB getdataService =new GetDataFromServiceDB();
      
        
        int lastID= getdataService.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
            c.setAutoCommit(false);
          //  System.out.println("Opened Books..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO ServiceTab (ID,LIBOFFID,LIBCARDNO,BOOKSID,ISSUEDATE,RETURNDATE) " +
                   "VALUES (?,?,?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);  
             pst.setString(2,libOffID);
             pst.setString(3,libCardNo);
             pst.setString(4,booksID);
             pst.setString(5,issueDate);
             pst.setString(6,returnDate);
             
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
            System.exit(0);
    }
        
        
    System.out.println("Person Records created successfully");
  //  JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
    }
    
    
    public static void main(String arg[])
    {
   
   InsertServiceDB ob=new InsertServiceDB();
   
   ob.InsertToDB("offid123","libcardid123","booksid123","10.07.2013", "25.07.2013");
      ob.InsertToDB("offid456","libcardid456","booksid456","10.07.2013", "25.07.2013");
     
   
    }
     
}
