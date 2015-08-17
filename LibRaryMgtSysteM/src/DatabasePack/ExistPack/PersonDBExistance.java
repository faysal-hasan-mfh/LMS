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
public class PersonDBExistance {
    
    File fl=new File("C:/LibMgtSys/Person.db");
    
    boolean dbExistence;
    
    public void showPathAndExistenc(){
    if(fl.exists()){
    
        System.out.println(fl.getName()+" exists");
        
        System.out.println(fl.isFile() ? "is a file" : "is not a file");
        
        System.out.println(fl.getAbsolutePath());
        
                }
    }
    
    public boolean PersonDBExist(){
    
        if(fl.exists()) {
            return true;
        }
        else {
            return false;
        }
    
  }
    
}
