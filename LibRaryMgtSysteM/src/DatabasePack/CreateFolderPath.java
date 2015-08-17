/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePack;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author faysal
 */
public class CreateFolderPath {
    
    boolean folder;
    public CreateFolderPath(){
    
        File fl=new File("C://LibMgtSys");
        boolean isPathCreated=fl.mkdir();
        if(isPathCreated)
        {
            System.out.println("folder created ....");
      //  JOptionPane.showMessageDialog(null, "FILE FOLDER SUCCESSFULLY CREATED...", "FILE PATH CREATED..", JOptionPane.INFORMATION_MESSAGE);
        this.folder=true;
        }
        else {
            this.folder=true;
        }
    }
    public boolean fileexist()
    {
        
    return folder;
    }
    
    public static void main(String arg[])
    {
        CreateFolderPath ob=new CreateFolderPath();
        
    }
}
