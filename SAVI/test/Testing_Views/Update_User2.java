
package Testing_Views;


import javax.swing.*;
import java.awt.*;
//import Model.BO.*;
import Model.DAO.*;
import Model.VO.*;

/*
Classe usada para actualizar dados do usúario
Legenda:
button[0] => Actualizar
button[1] => Limpar
button[2] => Voltar
___________________________
label[0] =>  BI (label)
label[1] =>  BI (Conteúdo)
label[2] => Nome Completo (label)
label[3] => Nome Completo (Conteúdo)
label[4] => Username
label[5] => Password
label[6] => E-mail
label[7] => Celular
label[8] => Bairro
label[9] => Rua
label[10] => Quarteirao
label[10] => Label vazio usado para melhorar o layout



*/




public class Update_User2 {
    
private JFrame window;
private JPanel panel[]= new JPanel[4];
private JLabel label[]= new JLabel[11];
private JTextField textField[]= new JTextField[7];
private JButton button[]= new JButton[3];
private String buttonText[]= {"ACTUALIZAR","LIMPAR", "VOLTAR"};
Usuario user;




public Update_User2(){
    
    window= new JFrame("ACTUALIZACAO DE DADOS");
    window.setSize(700,400);
    window.setLocationRelativeTo(null);
    user = new Usuario();
    String textField_PlaceHolder[]= {"Current username","Current password", "Current e-mail","Current cellphone", "Current neighborhood", "Current street", "Current quarter"};
    String labelText[]= {"BI: "," "+user.getBi()+"","Nome completo: ",""+user.getNome()+"  "+user.getApelido()+" ","Nome do usuario: ","Senha: ","E-mail: ","Celular: ","Bairro: ", "Rua: ", "Quarteirao: ", "  "};
    
    short i;
    for(i=0;i<label.length;i++){
        label[i]= new JLabel(labelText[i]);
        if(i<7)
            textField[i]= new JTextField(textField_PlaceHolder[i]);
        if(i<4)
            panel[i]= new JPanel();
        if(i<3)
            button[i]= new JButton(buttonText[i]);  
    }
        
   
    panel[0].setLayout(new GridBagLayout());
    panel[1].setLayout(new GridLayout(11,2));
    panel[2].setLayout(new GridBagLayout());
    
    
    for( i=0;i<label.length;i++){//adding labels on panel1
        panel[1].add(label[i]); 
        if(i>3 && i<11)
            panel[1].add(textField[i-4]);            
    }
     
    for( i=0; i<button.length;i++)//adding butttons on panel2
        panel[2].add(button[i]);
   
    
    
   
   panel[3].add(panel[2]);
   panel[1].add(panel[3]);
   panel[0].add(panel[1]);
   window.add(panel[0]);
   window.setVisible(true);
    
}

    public static void main(String args[]) throws Exception{
        
        Update_User2 up= new Update_User2();
        
    }

    
    
            
        
        
        
    
    
    
    
    
    
    
}
