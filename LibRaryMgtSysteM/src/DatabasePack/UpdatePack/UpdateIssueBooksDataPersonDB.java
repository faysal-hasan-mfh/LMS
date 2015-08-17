package DatabasePack.UpdatePack;

import java.sql.*;

public class UpdateIssueBooksDataPersonDB{
   
   public UpdateIssueBooksDataPersonDB(String issueNum,String libraryCard)
   {
   
    Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.sqlite.JDBC");

      //STEP 3: Open a connection
   //   System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection("jdbc:sqlite:c://LibMgtSys/Person.db");
      System.out.println("Connected update... Person database successfully...");
      
      //STEP 4: Execute a query
   //   System.out.println("Creating statement...");
      
      stmt = conn.createStatement();
     
      int is=Integer.parseInt(issueNum);
      String sql = "UPDATE PersonTab " +
                   "SET ISSUEBOOKSNUMBER = "+is+" WHERE LIBCARDNO in ("+libraryCard+")";
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
  
       UpdateIssueBooksDataPersonDB ob=new UpdateIssueBooksDataPersonDB("100","01");
}//end main
}//end JDBCExample