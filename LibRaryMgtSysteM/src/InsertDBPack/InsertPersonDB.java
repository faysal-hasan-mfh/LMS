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
public class InsertPersonDB {
    
    Connection c = null;
    Statement stmt = null;
    
    public void InsertToDB(String ID, String libCard, String memType, String name, String email, String address, String con1, String con2, String issueNum){
    
    
        GetDataFromPersonDB getdataPerson =new GetDataFromPersonDB();
      
        
        int lastID= getdataPerson.LastID();
        
        System.out.println("Last Id is: "+lastID);
         
        try {
      
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
            c.setAutoCommit(false);
          //  System.out.println("Opened Books..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO PersonTab (ID,PERSONID,LIBCARDNO,MEMBERTYPE,NAME,EMAIL,ADDRESS,CONTACT1,CONTACT2,ISSUEBOOKSNUMBER) " +
                   "VALUES (?,?,?,?,?,?,?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,ID);
             pst.setString(3,libCard);
             pst.setString(4,memType);
             pst.setString(5,name);
             pst.setString(6,email);
             pst.setString(7, address);
             pst.setString(8,con1);
             pst.setString(9,con2);
             pst.setString(10,issueNum);
             
             
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
   
   InsertPersonDB obj=new InsertPersonDB();
    obj.InsertToDB("Ash1001001","1", "Student","faysal","ldkd@gmail.com","rajs","01913984329","017151811451","0");
    obj.InsertToDB("Ash10010014","12", "Scvtudent","fayskkal","ldcvkd@gmail.com","rajs","01cv913984329","0171518cv11451","1");
     
   
    }
     
}
