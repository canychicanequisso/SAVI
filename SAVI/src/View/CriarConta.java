package View;

import Controller.*;
import javax.swing.*;
import java.awt.*;
//import Model.BO.*;
import Model.DAO.*;
import Model.VO.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Classe usada para actualizar dados do usúario


--------------------Legenda---------------------

- Botões
button[0] => Actualizar
button[1] => Limpar
button[2] => Voltar
___________________________
- Label's
label[0] =>  BI 
label[1] => Nome Completo
label[2] => Username
label[3] => Password
label[4] => E-mail
label[5] => Celular
label[6] => Bairro
label[7] => Rua
label[8] => Quarteirao
label[9] => Label vazio usado para melhorar o layout

*/


public class CriarConta implements ActionListener{
    
private JFrame window;
private JPanel panel[]= new JPanel[4];
private JLabel label[]= new JLabel[10];
private JTextField textField[]= new JTextField[9];
private JButton button[]= new JButton[4];
private String buttonText[]= {"ACTUALIZAR","ELIMINAR CONTA","LIMPAR","VOLTAR"};
private Usuario user;
private DAO_Usuario user_DAO;


    public CriarConta(){
    
        window= new JFrame("ACTUALIZACAO DE DADOS");
        window.setSize(900,400);
        window.setLocationRelativeTo(null);
        user_DAO= new DAO_Usuario();
        String textField_PlaceHolder[]= {user.getNomeUsuario(),""+user.getSenha()+"", user.getEmail(),""+user.getCelular()+"", user.getBairro(), user.getRua(), ""+user.getQuarteirao()+""};
        String labelText[]= {"BI: ","Nome completo: ","Nome do usuario: ","Senha: ","E-mail: ","Celular: ","Bairro: ", "Rua: ", "Quarteirao: ", "  "};
    
        short i;
        for(i=0;i<label.length;i++){
            label[i]= new JLabel(labelText[i]);
            if(i<textField.length)
                textField[i]= new JTextField(textField_PlaceHolder[i]);
            if(i<4)
                panel[i]= new JPanel();
            if(i<button.length)
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
                        errors = (v.validarString(errors,textField[i].getText(), 10, 25,i));
                        break;    
                           
                    case 3: 
                        errors = (v.validarInt(errors,textField[i].getText(), 821111111, 879999999,i));
                        break; 
                         
                    case 4: 
                        errors = (v.validarString(errors,textField[i].getText(), 3, 15,i));
                        break;
                        
                    case 5: 
                        errors = (v.validarString(errors,textField[i].getText(), 5, 15,i));
                        break;
                        
                    case 6: 
                        errors = (v.validarInt(errors,textField[i].getText(), 1, 99,i));
                        break;    
                      
                }
                   
            }
            
            if(errors.isEmpty()){
                user.setNomeUsuario(textField[0].getText());
                user.setSenha(Integer.parseInt(textField[1].getText()));
                user.setEmail(textField[2].getText());
                user.setCelular(Integer.parseInt(textField[3].getText()));
                user.setBairro(textField[4].getText());
                user.setRua(textField[5].getText());
                user.setQuarteirao(Integer.parseInt(textField[3].getText()));
                try {
                    user_DAO.alterar(user);
                } catch (Exception ex) {
                    Logger.getLogger(Update_Usuario.class.getName()).log(Level.SEVERE, null, ex);     
                }
                JOptionPane.showMessageDialog(null, "Actualizacao efectuada!","SUCESSO!",JOptionPane.INFORMATION_MESSAGE);
                window.setVisible(false);
                Update_Usuario w= new Update_Usuario(user);
            }
    
            else{
                String error= "Corrija os seguintes erros: \n";
                for(short  i=0; i<errors.size(); i++)
                    error+= "\n\n"+errors.elementAt(i);
                 JOptionPane.showMessageDialog(null, error,"ERRO!",JOptionPane.ERROR_MESSAGE);
            }
                
        }
        else if(e.getSource()==button[1]){
            try {
                user_DAO.excluir(user);
            } catch (Exception ex) {
                Logger.getLogger(Update_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource()==button[2]){
            for(short i=0; i<textField.length; i++)
                textField[i].setText("");
        }
        
        else if (e.getSource()==button[3])
            JOptionPane.showMessageDialog(null, "A funcionalidade esta' temporariamente indisponivel","FUNCIONALIDADE EM DESENVOLVIMENTO!",JOptionPane.WARNING_MESSAGE);
            
 
    }
        
     
    public static void main(String args[]) throws Exception{
        Usuario u= new Usuario();
        Update_Usuario up= new Update_Usuario(u);
    }
    
}

    
    
    



    

