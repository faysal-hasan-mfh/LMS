/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack.ExistPack;

import java.io.File;

/**
 *
 * @author faysal
 */
public class LibDBExistance {
    
    File fl=new File("C:/LibMgtSys/Librarian.db");
    
    boolean dbExistence;
    
    public void showPathAndExistenc(){
    if(fl.exists()){
    
        System.out.println(fl.getName()+" exists");
        
        System.out.println(fl.isFile() ? "is a file" : "is not a file");
        
        System.out.println(fl.getAbsolutePath());
        
                }
    }
    
    public boolean LibDBExist(){
    
        if(fl.exists()) {
            return true;
        }
        else {
            return false;
        }
    
  }
    
}
