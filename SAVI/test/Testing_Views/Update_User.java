
package Testing_Views;


import javax.swing.*;
import java.awt.*;
//import Model.BO.*;
import Model.DAO.*;
import Model.VO.*;

public class Update_User {
    
    JFrame window;
    JLabel label[]= new JLabel[6];
    String labelText[]= {"Nome do usuario: ","Senha: ","E-mail: ","Celular: ","Bairro: ", "Rua: ", "Quarteirao: "};
    JTextField textField[]= new JTextField[6];
    JButton btn[] = new JButton[2];
    String btnText[]= {"ACTUALIZAR", "VOLTAR"};
    JPanel panel[] = new JPanel[4];
    Usuario user;
    DAO_Usuario db;
    //username, senha, email, celular, rua, bairro e quarteirao
    
    public Update_User(){
        
        
        
        window= new JFrame(" ACTUALIZACAO DE DADOS ");
        window.setSize(500,600);
        window.setLocationRelativeTo(null);
        int i;
        
        String textField_PlaceHolder[]= {"Current username","Current password", "Current e-mail", "Current neighborhood", "Current street", "Current quarter"};

        
        for(i=0; i<label.length; i++){
            label[i]= new JLabel(labelText[i]);
            textField[i]= new JTextField(textField_PlaceHolder[i]);
            if(i<panel.length){
                panel[i]= new JPanel();
                if(i<btn.length)
                    btn[i]= new JButton(btnText[i]);
            }
                
            
        }
        
        
        
        panel[0].setLayout(new GridLayout(3,1));
        panel[1].setBackground(Color.red);
        
        panel[1].add(new JLabel("ACTUALIZACAO DE DADOS"));
        
        panel[2].setLayout(new GridLayout(8,2));
        panel[2].setBackground(Color.blue);
        panel[2].add(new JLabel("BI: "));
        panel[2].add(new JLabel("BI.nr()"));
        panel[2].add(new JLabel("Nome Completo: "));
        panel[2].add(new JLabel("Nome & Apelido"));
        
        for(i=0; i<label.length; i++){
            panel[2].add(label[i]);
            panel[2].add(textField[i]);    
        }
        
        
        
        panel[3].setLayout(new GridBagLayout());
        for(i=0; i<btn.length; i++)
            panel[3].add(btn[i]);
        
        panel[0].add(panel[1]);
        panel[0].add(panel[2]);
        panel[0].add(panel[3]);
        JPanel all= new JPanel();
        all.setLayout(new FlowLayout());
        all.add(panel[0]);
        //window.add(panel[0]);
        window.add(all, BorderLayout.CENTER);
        window.setVisible(true);
        
        
    }
    
    public static void main(String args[]) throws Exception{
        
        Update_User up= new Update_User();
        
    }
    
    
    
    
}
