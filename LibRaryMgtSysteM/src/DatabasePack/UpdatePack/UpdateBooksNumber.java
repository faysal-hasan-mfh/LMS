package DatabasePack.UpdatePack;

import java.sql.*;

public class UpdateBooksNumber{
   
   public UpdateBooksNumber(String returnNum,String booksID)
   {
   
    Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.sqlite.JDBC");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:sqlite:c://LibMgtSys/Books.db");
      System.out.println("Connected update... book database successfully...");
      
      //STEP 4: Execute a query
   //   System.out.println("Creating statement...");
      
      stmt = conn.createStatement();
     
      String sql = "UPDATE BooksTab " +
                   "SET AVAILABILITY = "+returnNum+" WHERE BOOKSID in ("+booksID+")";
      stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the updated records
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
 //  System.out.println("Goodbye!");
   
   }
   public static void main(String[] args) {
  
       UpdateBooksNumber o=new UpdateBooksNumber("50", "1001");
}//end main
}//end JDBCExample