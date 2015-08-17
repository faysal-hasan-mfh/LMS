/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author faysal
 */
public class DateDiff {
    
    
    public long getDateDifference(String date1, String date2)
    {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
 
		Date d1 = null;
		Date d2 = null;
                
                long diffDays=0;
        
        try {
			d1 = format.parse(date1);
			d2 = format.parse(date2);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			//long diffSeconds = diff / 1000 % 60;
			//long diffMinutes = diff / (60 * 1000) % 60;
			//long diffHours = diff / (60 * 60 * 1000) % 24;
			 diffDays = diff / (24 * 60 * 60 * 1000);
 
		//	System.out.println(diffDays + " days.");
			//System.out.print(diffHours + " hours, ");
			//System.out.print(diffMinutes + " minutes, ");
			//System.out.print(diffSeconds + " seconds.");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        
        
        
        
        
    
    return diffDays;
    }
    
    
    
    public static void main(String arg[])
    {
    
        DateDiff ob=new DateDiff();
        
        ob.getDateDifference("27/03/2014", "31/03/2014");
    
    }
}
