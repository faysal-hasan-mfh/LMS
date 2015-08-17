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
public class GetDataFromPersonDB {
     Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    String allInfo[]= new String[12];;
    int id[]=new int[5000];
    
   PersonDBExistance dbe=new PersonDBExistance();
    
    
    int getLastId;
    
    
   // method....
    
    
    
    
    public String[] getPNFromDB(){
    
     // this will send all person name......as string array....
    
        if(dbe.PersonDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
              //  System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
              int count=0;
      
              while ( rs.next() ) {
          
                  this.web_name[count]=rs.getString("NAME");
        
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
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
    
    
    
    
    
    
    
    
    public int[] getIDFromDB(){
    
   if(dbe.PersonDBExist()){     
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void showPNFromDB(String []wn ){
        
        // this will show taken person name string array...
      
     /* 
      int count2=0;
      while(count2<sub_name.length)
      {
      
          if(sub_name[count2]!=null)
          System.out.println(sub_name[count2]);
          
          ++count2;
      }
        
    */
        
        int count2=0;
      while(count2<wn.length)
      {
      
          if(web_name[count2]!=null) {
              System.out.println(wn[count2]);
          }
          
          ++count2;
      }
        
    }
    
    
    
    
    
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
        
        int count3=0;
      while(count3<id.length)
      {
      
          if(web_name[count3]!=null) {
              System.out.println(id[count3]);
          }
          
          ++count3;
      }
        
    }
    
    
    
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
    
        if(dbe.PersonDBExist()){     
        
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return getLastId;
    }
   
    }
    
    
    
    
    
    
    
    
    
    
    
     public String[] getAllPersonInfoFromDB(String targetPersonName){
    
     //send all person info...............
    
        if(dbe.PersonDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              //  int id  = rs.getInt("ID");
         
         String personId = rs.getString("PERSONID");
         String libraryCard = rs.getString("LIBCARDNO");
          String memType = rs.getString("MEMBERTYPE");
         String name = rs.getString("NAME");
         String email= rs.getString("EMAIL");
         String address= rs.getString("ADDRESS");
         String contact1 = rs.getString("CONTACT1");
         String contact2= rs.getString("CONTACT2");
         String issuebooks= rs.getString("ISSUEBOOKSNUMBER");
         
                  if(targetPersonName.equals(name))
                  {
                      
                      allInfo[0]="ID>                                      "+personId;
                      allInfo[1]="Library card>                     "+libraryCard;
                      allInfo[2]="Member Type>                  "+memType;
                      allInfo[3]="Name>                                "+name;
                      allInfo[4]="E-mail>                               "+email;
                      allInfo[5]="Address>                            "+address;
                      allInfo[6]="Contact1>                           "+contact1;
                      allInfo[7]="Contact2>                           "+contact2;
                      allInfo[8]="IssueBooks>                      "+issuebooks;
                      
     //                  System.out.print("ID: >>" + id);
   //      System.out.print(",         lib off id :>>" + loid);
    //     System.out.print(",        name: >>" + name);
   //      System.out.print(",        email: >>" + email);
   //      System.out.println(",      address: >>" + address);
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
        
            return allInfo;
      
    }
    else{
 //   JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return allInfo;
    }
    }
    
    
    
    
    
    
    
    
    
    
     public boolean getLibCardExistFromDB(String targetLibCard){
    
         // same.. library card exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.PersonDBExist()){
        
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
    
      
    
     public boolean getPersongIDExistFromDB(String targetPersonID){
    
         // same.. ID of person exist or not................
         
         
         
         
     boolean isFound=false;
    
        if(dbe.PersonDBExist()){
        
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
     
     
     
     
     public boolean getPersonNameExistFromDB(String targetPersonName){
    
     boolean isFound=false;
    
        if(dbe.PersonDBExist()){
        
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
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
    
       
     
     
     
    
     public int getIssueBooksNumFromDB(String targetLibraryCard){
    
     int availableNumber=0;
    
        if(dbe.PersonDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Person.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PersonTab;" );
   
              
      
              while ( rs.next() ) {
          
              
         String libcard= rs.getString("LIBCARDNO");
        int available = rs.getInt("ISSUEBOOKSNUMBER");
        
         
                  if(targetLibraryCard.equals(libcard))
                  {
                   availableNumber=available;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      
      System.exit(0);
    }
        
            return availableNumber;
      
    }
    else{
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return availableNumber;
    }
    }
    
     
    public static void main( String args[] )
  {
   
    
    GetDataFromPersonDB ob=new GetDataFromPersonDB();
    
      System.out.println("Last ID is: "+ob.LastID());
    
      
      ob.showPNFromDB(ob.getPNFromDB());
      
      System.out.println("Lib Card> "+ ob.getLibCardExistFromDB("a01"));
      
      System.out.println("Lib Card> "+ ob.getPersonNameExistFromDB("faysal"));
      System.out.println("Lib Card> "+ ob.getIssueBooksNumFromDB("ac01"));
      
      System.out.println("> "+ob.getAllPersonInfoFromDB("faysal"));
    
  }
}
