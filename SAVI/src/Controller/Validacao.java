
package Controller;

import java.util.Vector;



/**
 *
 * @author Grupo_01
 */
public class Validacao {
    
    private String aux[] = {"BI: ","Nome: ","Apelido: ","Nome do usuario: ","Senha: ","E-mail: ","Celular: ","Bairro: ", "Rua: ", "Quarteirao: "};
    private String intError, StringError;
    
    public Validacao(){
       intError = "Certifique-se que introduziu um valor inteiro no intervalo de: ";
       StringError = "Certifique-se que nao introduziu nenhum algarismo, e, que o nr de caracteres esta' entre:  ";
    }
    
    
    
    public  Vector validarString(Vector error,String str, int a, int b, int indice){
        
        if(((str.equals("") || !str.matches("^[a-zA-Z]*$")) || str.length() < a) || str.length() > b){
            error.addElement("- "+aux[indice+3]+StringError+" "+a+ "- "+b);
            return error;
        }
        else
            return error;
            
    }
    
    public Vector validarInt(Vector error,String str, int a, int b, int indice){
        boolean erro= false;
        int valor=0;
        try{
             valor= Integer.parseInt(str);
        }catch(NumberFormatException g1){
            erro= true;
        }
        
        if( erro || valor<a || valor>b){
            error.addElement("- "+aux[indice+3]+intError+" "+a+ "- "+b);
            return error;
        }
           
        else
            return error;
    }
    
    
}
