/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack;

import DatabasePack.ExistPack.LibDBExistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateLibrarianDB {
    
    
    
    Connection c = null;
    Statement stmt = null;
    CreateFolderPath cfp=new CreateFolderPath();
    LibDBExistance lde=new LibDBExistance();
    public void createDatabaseMethod(){
    
        if(cfp.fileexist()&&!(lde.LibDBExist())){
        
        
                 try {
                     Class.forName("org.sqlite.JDBC");
                     c = DriverManager.getConnection("jdbc:sqlite:c://LibMgtSys/Librarian.db");
      
      
                      System.out.println("Opened librarian .... database successfully");
                    //  JOptionPane.showMessageDialog(null, "Librarian....Database Successfully Created...", "Database Info : ", JOptionPane.INFORMATION_MESSAGE);
    
      
      stmt = c.createStatement();
      String sql = "CREATE TABLE LibrarianTab " +
                   "(ID INT PRIMARY KEY," + 
                   "LIBOFFICERID TEXT," +
                   "NAME TEXT," +
                   "EMAIL TEXT," +
                   "ADDRESS TEXT," +
                   "CONTACT1 TEXT," +
                   "CONTACT2 TEXT," +
                   "PASSWORD TEXT)";
                   
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("From CreateDatabase");
      System.exit(0);
    }
    System.out.println("Table created successfully");
    }
     else
    {
    JOptionPane.showMessageDialog(null, "sorry.. file path is not existed..OR .. already exists...", "Error..", JOptionPane.ERROR_MESSAGE);
    
   //  int getvalue=JOptionPane.showConfirmDialog(null, "Do you want to create file folder ? ", "Create path?", JOptionPane.YES_NO_OPTION);
    
  //   if(getvalue==0)
   //  {
   //  CreateFolderPath cfp=new CreateFolderPath();
  //   }
  //   else{
  //   JOptionPane.showMessageDialog(null,"You must have to create folder to access DB.."
  //           + "", "Info: ", JOptionPane.WARNING_MESSAGE);
  //   }
    
    }
        
        
        
        
   }
    
   
    public static void main(String arg[]){
    
   CreateLibrarianDB obj=new CreateLibrarianDB();
    obj.createDatabaseMethod();
    }
     
   
}
