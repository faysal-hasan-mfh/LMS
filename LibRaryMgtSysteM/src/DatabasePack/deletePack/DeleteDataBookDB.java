/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack.deletePack;

/**
 *
 * @author faysal
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import DatabasePack.ExistPack.BooksDBExistance;
import DatabasePack.ExistPack.ServiceDBExistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class DeleteDataBookDB {
    
    Connection c = null;
    Statement stmt = null;
    BooksDBExistance dbe=new BooksDBExistance();
    
    
    
    public void deleteItem(String getbooksId)
    {
    
        if(dbe.BooksDBExist()){ 
                
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:c:/LibMgtSys/Books.db");
                c.setAutoCommit(false);
      
                System.out.println("Opened Service database successfully from DeleteFromDB ");

                stmt = c.createStatement();
                String sql = "DELETE FROM BooksTab WHERE LIBCARDNO=?";
                
                PreparedStatement pst= c.prepareStatement(sql);
                
                pst.setString(1,getbooksId);
                pst.executeUpdate();
                c.commit();
                
                
                 
                stmt.close();
                c.close();
             }
            catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                   System.exit(0);
                }
    
            System.out.println("Operation done successfully");
          //  JOptionPane.showMessageDialog(null, "Item Successfully Deleted.", "Delete Option: ", JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    else{
          //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    
    // delete all item.............
    
    
    
    public void deleteAllItem()
    {
    
        if(dbe.BooksDBExist()){ 
                
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:c:/LibMgtSys/Books.db");
                c.setAutoCommit(false);
      
                System.out.println("Opened Service database successfully from DeleteFromDB  delete allll ");

                stmt = c.createStatement();
                String sql = "DELETE FROM BooksTab";
                
                PreparedStatement pst= c.prepareStatement(sql);
                
                pst.executeUpdate();
                c.commit();
                
                
                 
                stmt.close();
                c.close();
             }
            catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                   System.exit(0);
                }
    
            System.out.println("All Data Deleted successfully");
         //   JOptionPane.showMessageDialog(null, " ALL Item Successfully Deleted.", "Delete Option: ", JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    else{
          //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    }
        
    }
    
    
    
    
    
    public static void main(String arg[])
    {
       
    }
   
}

