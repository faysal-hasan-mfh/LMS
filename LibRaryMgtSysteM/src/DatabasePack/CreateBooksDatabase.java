/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack;

import DatabasePack.ExistPack.BooksDBExistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateBooksDatabase {
    
    
    
    Connection c = null;
    Statement stmt = null;
    CreateFolderPath cfp=new CreateFolderPath();
    BooksDBExistance bde=new BooksDBExistance();
    public void createDatabaseMethod(){
    
        if(cfp.fileexist()&& !(bde.BooksDBExist())){
        
        
                 try {
                     Class.forName("org.sqlite.JDBC");
                     c = DriverManager.getConnection("jdbc:sqlite:c://LibMgtSys/Books.db");
      
      
                      System.out.println("Opened books ...database successfully");
                   //   JOptionPane.showMessageDialog(null, "Books....Database Successfully Created...", "Database Info : ", JOptionPane.INFORMATION_MESSAGE);
    
      
      stmt = c.createStatement();
      String sql = "CREATE TABLE BooksTab " +
                   "(ID INT PRIMARY KEY," + 
                   " BOOKSID TEXT," +
                   " BOOKSTITLE TEXT," +
                   " BOOKSGROUP TEXT," +
                   " BOOKSSERIAL TEXT," +
                   " ISBNNO TEXT," +
                   " AUTHOR TEXT,"+
                    " AVAILABILITY NUMBER)";
                   
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
   // JOptionPane.showMessageDialog(null, "sorry.. file path is not existed..OR .. already exists...", "Error..", JOptionPane.ERROR_MESSAGE);
    
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
    
   CreateBooksDatabase obj=new CreateBooksDatabase();
    obj.createDatabaseMethod();
    }
     
   
}
