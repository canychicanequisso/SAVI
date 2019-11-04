package View;

import Controller.*;
import javax.swing.*;
import java.awt.*;
//import Model.BO.*;
import Model.DAO.*;
import Model.VO.*;
import java.awt.event.*;
import java.util.Vector;

/*
Classe usada para actualizar dados do usúario


--------------------Legenda---------------------

- Botões
button[0] => Actualizar
button[1] => Limpar
button[2] => Voltar
___________________________
- Label's
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


public class Update_Usuario implements ActionListener{
    
private JFrame window;
private JPanel panel[]= new JPanel[4];
private JLabel label[]= new JLabel[12];
private JTextField textField[]= new JTextField[7];
private JButton button[]= new JButton[3];
private String buttonText[]= {"ACTUALIZAR","LIMPAR", "VOLTAR"};
private Usuario user;
private DAO_Usuario user_DAO;


    public Update_Usuario(Usuario usuario){
    
        window= new JFrame("ACTUALIZACAO DE DADOS");
        window.setSize(700,400);
        window.setLocationRelativeTo(null);
    
    
        user= usuario;
        user.setNomeUsuario("Joao");
        String textField_PlaceHolder[]= {user.getNomeUsuario(),""+user.getSenha()+"", user.getEmail(),""+user.getCelular()+"", user.getBairro(), user.getRua(), ""+user.getQuarteirao()+""};
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
        panel[1].setLayout(new GridLayout((label.length)+1,2));
        panel[2].setLayout(new GridBagLayout());
    
        for(i=0;i<label.length;i++){ //ciclo usado para adicionar label's e campos de texto ao painel_1
            panel[1].add(label[i]); 
            if(i>3 && i<11)
                panel[1].add(textField[i-4]);            
        }
     
        for( i=0; i<button.length;i++) //ciclo usado para adicionar botões ao painel_2
            panel[2].add(button[i]);
        
        for(i=0; i<button.length; i++)//ciclo usado para adicionar lstener's aos botões d1o painel_2
            button[i].addActionListener(this);
   
   
        panel[3].add(panel[2]);
        panel[1].add(panel[3]);
        panel[0].add(panel[1]);
        window.add(panel[0]);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Validacao v= new Validacao();
        Vector errors= new Vector();
        
        

        
        if(e.getSource()==button[0]){    
            
            
            for(int i=0; i<textField.length; i++){
                
                switch(i){
                    case 0: 
                        errors = (v.validarString(errors,textField[i].getText(), 3, 15,i));
                        break;
                        
                    case 1: 
                        errors = (v.validarInt(errors,textField[i].getText(), 1111, 9999,i));
                        break;
                          
                    case 2: 
                        errors = (v.validarString(errors,textField[i].getText(), 16, 25,i));
                        break;    
                           
                    case 3: 
                        errors = (v.validarString(errors,textField[i].getText(), 821111111, 879999999,i));
                        break; 
                         
                    case 4: 
                        errors = (v.validarString(errors,textField[i].getText(), 3, 15,i));
                        break;
                        
                    case 5: 
                        errors = (v.validarString(errors,textField[i].getText(), 5, 15,i));
                        break;
                        
                    case 6: 
                        errors = (v.validarString(errors,textField[i].getText(), 1, 99,i));
                        break;    
                      
                }
                  
                
                      
            }
            
            if(errors.isEmpty())
               JOptionPane.showMessageDialog(null, "Actualizacao efectuada!","SUCESSO!",JOptionPane.INFORMATION_MESSAGE); 
            
                
                
            else{
                String error= "Corrija os seguintes erros: \n";
                for(short  i=0; i<errors.size(); i++)
                    error+= "\n\n"+errors.elementAt(i);
                 JOptionPane.showMessageDialog(null, error,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }
               


                
        }
        
    }
        
    
    
    public static void main(String args[]) throws Exception{
        Usuario u= new Usuario();
        Update_Usuario up= new Update_Usuario(u);
    }
    
}

    
    
    



    

