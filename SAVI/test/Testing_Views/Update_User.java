
package Testing_Views;


import javax.swing.*;
import java.awt.*;
//import Model.BO.*;
import Model.DAO.*;
import Model.VO.*;
import java.io.*;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Update_User {
    
    
  
    
    public static void main(String args[]) throws Exception{
        
       Vector a= new Vector();
      
       a=validarString(a,false);
       if(a.isEmpty())
            System.out.println("Vazio");
       else
            System.out.println("Contains sh*t");
          
       
            
    }
    
    public static Vector validarString(Vector err, boolean parametro){
        
        if(parametro){
            err.addElement("erdfsd");
            return err;
        }
        else return err;
            
                
    }
    
    
    
}
