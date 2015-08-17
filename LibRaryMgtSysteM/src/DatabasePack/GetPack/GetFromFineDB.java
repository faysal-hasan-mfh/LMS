/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack.GetPack;

import DatabasePack.ExistPack.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class GetFromFineDB {
     Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    String allInfo[][]= new String[1000][1000];;
    int id[]=new int[5000];
    
  FineDBExistance dbe=new FineDBExistance();
    
    
    int getLastId;
    
    
   // method....
    
    
    
    
    public String[] getFineLibCardFromDB(){
    
     // this will send all person name......as string array....
    
        if(dbe.FineDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
                c.setAutoCommit(false);
              //  System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FineTab;" );
      
              int count=0;
      
              while ( rs.next() ) {
          
                  this.web_name[count]=rs.getString("LIBCARDNO");
        
                      ++count;
                }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
        return web_name;
    }
    else{
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
    
    
    
    
    
    
    
    /*
    public int[] getIDFromDB(){
    
   if(dbe.ServiceDBExist()){     
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
      c.setAutoCommit(false);
   //   System.out.println("Opened librarian database ID successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
      int countID=0;
      while ( rs.next() ) {
          
     
         this.id[countID]=rs.getInt("ID");
       
         
         ++countID;
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
        
        return id;
   }
   else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return id;
    }
   
    }
    
    
    
    
    */
    
    
    
    
    
    
    
    
    
    public void showFineLibCardFromDB(String []wn ){
        
        // this will show taken person name string array...
      
     
        
    
        
        int count2=0;
      while(count2<wn.length)
      {
      
          if(web_name[count2]!=null) {
              System.out.println(wn[count2]);
          }
          
          ++count2;
      }
        
    }
    
    
    
    
    /*
    public void showIDFromDB(int []id ){
        
      
     /* 
      int count2=0;
      while(count2<sub_name.length)
      {
      
          if(sub_name[count2]!=null)
          System.out.println(sub_name[count2]);
          
          ++count2;
      }
        
    */
        /*
        int count3=0;
      while(count3<id.length)
      {
      
          if(web_name[count3]!=null) {
              System.out.println(id[count3]);
          }
          
          ++count3;
      }
        
    }
    
    */
    
     public int totalID(String []wn ){
        
     int totalIDnum=0,countid=0;
      while((countid<wn.length)&&(web_name[countid]!=null))
      {
      
       totalIDnum= ++countid;
        
      }
        
      
      return totalIDnum;
      
    }
    
     // Last id       ,,,,,,,,,,,,,............
     
    public int LastID(){
    
        if(dbe.FineDBExist()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
                c.setAutoCommit(false);
      
             //   System.out.println("Opened librarian database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FineTab;" );
      
       int countID=0;
                 while ( rs.next() ) {
                         this.id[countID]=rs.getInt("ID");
                           getLastId=id[countID];
                        ++countID;
                        }
                 
      
                 rs.close();
                 stmt.close();
                   c.close();
            }
            catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                        System.exit(0);
                }
        
        return getLastId;
   }
   else{
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return getLastId;
    }
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
     public boolean getLibCardExistFromDB(String targetLibCard){
    
         // same.. library card exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.BooksDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("LIBCARDNO");
        
         
                  if(targetLibCard.equals(loid))
                  {
                     isFound=true;
                  break;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return isFound;
      
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
    
      
    
     public boolean getPersongIDExistFromDB(String targetPersonID){
    
         // same.. ID of person exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.BooksDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("PERSONID");
        
         
                  if(targetPersonID.equals(loid))
                  {
                     isFound=true;
                  break;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return isFound;
      
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
     
     
     
     
     public boolean getPersonNameExistFromDB(String targetPersonName){
    
     boolean isFound=false;
    
        if(dbe.BooksDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("NAME");
        
         
                  if(targetPersonName.equals(loid))
                  {
                     isFound=true;
                  break;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return isFound;
      
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
    
       
     
     */
     
    
     
    
     public String getDueDateFromDB(String targetLibraryCard){
    
     String issueDate = null;
    
        if(dbe.FineDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FineTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        String issueDateTemp = rs.getString("DUEDATE");
        
         
                  if(targetLibraryCard.equals(libcard))
                  {
                   issueDate=issueDateTemp;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return issueDate;
      
    }
    else{
    //JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return issueDate;
    }
    }
    
     
     public int getFineAmountFromDB(String targetLibraryCard){
    
    int fineAmount=0;
    
        if(dbe.FineDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FineTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        int finetemp = rs.getInt("FINE");
        
         
                  if(targetLibraryCard.equals(libcard))
                  {
                   fineAmount=finetemp;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return fineAmount;
      
    }
    else{
 //   JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return fineAmount;
    }
    }
    
     
     
     
      public String[][] getAllFineInfoFromDB(){
    
     //send all person info...............
    
        if(dbe.FineDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Fine.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM FineTab;" );
      
                
               
                
             
              
              int fcount=0;
      
              while ( rs.next() ) {
          
              //  int id  = rs.getInt("ID");
         
         
         String libraryCard = rs.getString("LIBCARDNO");
      
         String dueDate = rs.getString("DUEDATE");
         String fine= String.valueOf(rs.getInt("FINE"));
         
         
                  
                  allInfo[fcount][0]=libraryCard;
                  allInfo[fcount][1]= dueDate;
                  allInfo[fcount][2]= fine;
                  
                  ++fcount;
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return allInfo;
      
    }
    else{
 //   JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return allInfo;
    }
    }
    
     
     
     
     
     
     
    public static void main( String args[] )
  {
   
    
   GetFromFineDB ob=new GetFromFineDB();
    
      System.out.println("Last ID is: "+ob.LastID());
    
    ob.showFineLibCardFromDB(ob.getFineLibCardFromDB());
    
    System.out.println("Due Date>>"+ob.getDueDateFromDB("lib-50101"));
    
    System.out.println("Fine Amount>>>"+ob.getFineAmountFromDB("lib-50101"));
 
        
      
      
      String gk[][]=ob.getAllFineInfoFromDB();
      for(int i=0;i<ob.LastID();++i)
      {
          for(int j=0;j<gk.length;++j)
          {
          if(gk[i][j]!=null)
          {
          System.out.printf("  >> "+gk[i][j]);
          }
          else {
                  break;
              }
          }
          System.out.println();
      
      }
      
  }
}
