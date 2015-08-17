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
public class GetDataFromServiceDB {
     Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    String allInfo[][]= new String[1000][1000];;
    int id[]=new int[5000];
    
  ServiceDBExistance dbe=new ServiceDBExistance();
    
    
    int getLastId;
    
    
   // method....
    
    
    
    
    public String[] getPNFromDB(){
    
     // this will send all person name......as string array....
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
              //  System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
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
    
    
    
    
    
    
    
    
    
    public void showPNFromDB(String []wn ){
        
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
    
        if(dbe.ServiceDBExist()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
      
             //   System.out.println("Opened librarian database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public boolean getLibCardExistFromDB(String targetLibCard){
    
         // same.. library card exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
                
               
                
             
              
              
      
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
    
      
    
     public boolean getBooksIDExistFromDB(String targetBooksId){
    
         // same.. ID of person exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("PERSONID");
        
         
                  if(targetBooksId.equals(loid))
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
     
     
     
    /* 
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
     
    
     
    
     public String getIssueDateFromDB(String targetLibraryCard){
    
     String issueDate = null;
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        String issueDateTemp = rs.getString("ISSUEDATE");
        
         
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return issueDate;
    }
    }
    
     
     public String getReturnDateFromDB(String targetLibraryCard){
    
     String returnDate = null;
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        String returnDateTemp = rs.getString("RETURNDATE");
        
         
                  if(targetLibraryCard.equals(libcard))
                  {
                   returnDate=returnDateTemp;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return returnDate;
      
    }
    else{
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return returnDate;
    }
    }
    
     
      
     public String getBooksIDFromDB(String targetLibraryCard){
    
     String returnDate = null;
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        String returnDateTemp = rs.getString("BOOKSID");
        
         
                  if(targetLibraryCard.equals(libcard))
                  {
                   returnDate=returnDateTemp;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return returnDate;
      
    }
    else{
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return returnDate;
    }
    }
     
     
     
      public String[][] getAllServiceInfoFromDB(){
    
     //send all person info...............
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
                
               
                
             
              
              int fcount=0;
      
              while ( rs.next() ) {
          
              //  int id  = rs.getInt("ID");
         
         String libOfficialId = rs.getString("LIBOFFID");
         String libraryCard = rs.getString("LIBCARDNO");
          String booksID = rs.getString("BOOKSID");
         String issueDate = rs.getString("ISSUEDATE");
         String returnDate= rs.getString("RETURNDATE");
         
         
                  allInfo[fcount][0]=libOfficialId;
                  allInfo[fcount][1]=libraryCard;
                  allInfo[fcount][2]=booksID;
                  allInfo[fcount][3]= issueDate;
                  allInfo[fcount][4]= returnDate;
                  
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
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return allInfo;
    }
    }
    
     
      public String[][] getAllServiceInfoFromLibCardFromDB(String targetLibraryCardNo){
    
     //send all person info...............
    
        if(dbe.ServiceDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Service.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ServiceTab;" );
      
                
               
                
             
              
              int fcount=0;
      
              while ( rs.next() ) {
          
              //  int id  = rs.getInt("ID");
         
         String libOfficialId = rs.getString("LIBOFFID");
         String libraryCard = rs.getString("LIBCARDNO");
          String booksID = rs.getString("BOOKSID");
         String issueDate = rs.getString("ISSUEDATE");
         String returnDate= rs.getString("RETURNDATE");
         
         
         
         
         if(targetLibraryCardNo.equals(libraryCard))
         {
         allInfo[fcount][0]=libOfficialId;
         allInfo[fcount][1]=booksID;
         allInfo[fcount][2]=issueDate;
         allInfo[fcount][3]=returnDate;
            ++fcount;
         }
         
         
         
         
         /*
                  allInfo[fcount][0]=libOfficialId;
                  allInfo[fcount][1]=libraryCard;
                  allInfo[fcount][2]=booksID;
                  allInfo[fcount][3]= issueDate;
                  allInfo[fcount][4]= returnDate;
            */      
               
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
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return allInfo;
    }
    }
     
     
     
     
     
    public static void main( String args[] )
  {
   
    
   GetDataFromServiceDB ob=new GetDataFromServiceDB();
    
      System.out.println("Last ID is: "+ob.LastID());
    
    
      
  //    System.out.println(">issue date "+ob.getIssueDateFromDB("1234"));
   //    System.out.println(">return date "+ob.getReturnDateFromDB("1234"));
    
       

     //  ob.showPNFromDB(ob.getPNFromDB());
       
       
     // System.out.println("Length:> "+ob.getAllServiceInfoFromDB().length);
      
      
      //////////////////////////////////////...................
     /* 
      String gk[][]=ob.getAllServiceInfoFromDB();
      for(int i=0;i<ob.LastID();++i)
      {
          for(int j=0;j<gk.length;++j)
          {
          if(gk[i][j]!=null)
          {
          System.out.printf(">> "+gk[i][j]);
          }
          else {
                  break;
              }
          }
          System.out.println();
      
      }
      */
      
     // GetDataFromPersonDB gp=new GetDataFromPersonDB();
      /*
       String gk[][]=ob.getAllServiceInfoFromLibCardFromDB("14");
       int getIssueNum= gp.getIssueBooksNumFromDB("14");
       
     //  System.out.println("length > "+gk.length);
     //  System.out.println("length > "+gk[0].length);
      for(int i=0;i<getIssueNum;++i)
      {
          for(int j=0;j<gk.length;++j)
          {
          if(gk[i][j]!=null)
          {
          System.out.printf(">> "+gk[i][j]);
          }
          else {
                  break;
              }
          }
          System.out.println();
      
      }
      */
      
    System.out.println(ob.getBooksIDFromDB("02"));
  }
}
