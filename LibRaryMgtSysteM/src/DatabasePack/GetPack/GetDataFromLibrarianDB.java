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
public class GetDataFromLibrarianDB {
     Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    String allInfo[]= new String[8];;
    int id[]=new int[5000];
    
    LibDBExistance dbe=new LibDBExistance();
    
    
    int getLastId;
    
    
   // method....
    
    public String[] getWNFromDB(){
    
     
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
              //  System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
    
    
    
    
    
    
    
    
    public int[] getIDFromDB(){
    
   if(dbe.LibDBExist()){     
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
      c.setAutoCommit(false);
   //   System.out.println("Opened librarian database ID successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
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
    //JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return id;
    }
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void showWNFromDB(String []wn ){
        
      
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
    
        if(dbe.LibDBExist()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
      
             //   System.out.println("Opened librarian database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
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
    
    
    
    
    
    
    
    
    
    
    
     public String[] getAllInfoFromDB(String targetName){
    
     
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
                int id  = rs.getInt("ID");
         
         String loid = rs.getString("LIBOFFICERID");
         String name = rs.getString("NAME");
          String email = rs.getString("EMAIL");
         String address = rs.getString("ADDRESS");
         String contact1= rs.getString("CONTACT1");
         String contact2= rs.getString("CONTACT2");
         String password= rs.getString("PASSWORD");
         
                  if(targetName.equals(name))
                  {
                      
                      allInfo[0]="ID:                         "+String.valueOf(id);
                      allInfo[1]="Official ID:             "+loid;
                      allInfo[2]="Name:                 "+name;
                      allInfo[3]="Email:                "+email;
                      allInfo[4]="Address:              "+address;
                      allInfo[5]="Contact1:             "+contact1;
                      allInfo[6]="Contact2:             "+contact2;
                      
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
   // JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return allInfo;
    }
    }
    
    
    
    
    
    
    
    
    
    
     public boolean getOfficerExistFromDB(String targetOffID){
    
     boolean isFound=false;
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("LIBOFFICERID");
        
         
                  if(targetOffID.equals(loid))
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
    
    
    
     public boolean getAdNameExistFromDB(String targetName){
    
     boolean isFound=false;
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
            //    System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("NAME");
        
         
                  if(targetName.equals(loid))
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
    
     
     public boolean getPasswordFromDB(String targetName){
    
     boolean isFound=false;
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
         //       System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("PASSWORD");
        
         
                  if(targetName.equals(loid))
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
    
     
     public String getAdminNameFromDB(String targetName){
    
     String adminName=null;
    
        if(dbe.LibDBExist()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:C:/LibMgtSys/Librarian.db");
                c.setAutoCommit(false);
             //   System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM LibrarianTab;" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("NAME");
        
         
                  if(targetName.equals(loid))
                  {
                     adminName=loid;
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
        
            return adminName;
      
    }
    else{
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return adminName;
    }
    }
    
     
     
    public static void main( String args[] )
  {
    
    GetDataFromLibrarianDB ob=new GetDataFromLibrarianDB();
      
  //  String [] WNarr=  ob.getWNFromDB();
   //   ob.showWNFromDB(WNarr);
      
      
//    int []IDarr= ob.getIDFromDB(); 
  //    ob.showIDFromDB(IDarr);
    
    //  System.out.println("Total inserted ID : "+ ob.totalID(WNarr));
      
    
    
    
      System.out.println("Last ID is: "+ob.LastID());
    
      
      
      
      
      /*
    String ai[]=ob.getAllInfoFromDB("E");
    
    for(int i=0;i<ai.length;i++)
    {
    
    System.out.println(ai[i]);
    }
    * */
      
  //    System.out.println("Get > :"+ob.getOfficerExistFromDB("NSTU-CSTE-101"));
      
   //   System.out.println("Get > :"+ob.getAdNameExistFromDB("dfg"));
      
      System.out.println("Get > :"+ob.getAdminNameFromDB("dfg"));
      
  }
}
