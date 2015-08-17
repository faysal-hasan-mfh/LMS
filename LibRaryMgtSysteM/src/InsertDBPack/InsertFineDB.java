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
public class InsertFineDB {
    
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB(String libraryCardNo, String dueDate, int fine)
    {
    
    
        GetFromFineDB getdataFine=new GetFromFineDB();
      
        
        int lastID= getdataFine.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
            c.setAutoCommit(false);
          //  System.out.println("Opened Books..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO FineTab (ID,LIBCARDNO,DUEDATE,FINE) " +
                   "VALUES (?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,libraryCardNo);
             pst.setString(3,dueDate);
             pst.setInt(4,fine);
            
             
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
            System.exit(0);
    }
        
        
    System.out.println("Fine Records created successfully");
  //  JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
    }
    
    
    public static void main(String arg[])
    {
   
   InsertFineDB ob=new InsertFineDB();
   
   ob.InsertToDB("lib-50101", "15", 150);
    
   
    }
     
}
