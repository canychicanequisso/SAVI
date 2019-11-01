/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import static View.Login_View.p3;
import Model.DAO.DAO_Usuario;
import static View.Login_View.p3;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;



/**
 *
 * @author Chicanequisso
 */
public class Login_View2  extends JFrame implements ActionListener{
     private JButton comprar,voltar;
    private JLabel preco;
    private JButton pesquisar, notificacoes, paginaInicial, publicarAnuncio, estatisticas, login, informacoes, registar,lo;
    private PainelFundo principal; 
    private JTextField max,min,email;
    JPasswordField senha;
    JLabel senhaL,emailL;
    private JComboBox cb,cb1,cb2,cb3,cb4;
    private JSpinner scasa,squarterao;
    private String bairros [] =  {"Bairro","HULENE","LAULANE","ZIMPETO","MAHOTAS","ALBAZINE","MUSEU","BAIXA","TCHUMENE","TRINFO","MAXAQUENE"};
    private JPanel prefab;
    private JPanel p3 ;
    

    
    
    public Login_View2() {
         setTitle("JANELA");
         setSize(820,640);
         setLocation(250,50);
         principal = new PainelFundo("src/Imagens/esquerdo.png");
         principal.setLayout(null);
        
         //p3 = new PainelFundo("src/Imagens/LOGIN.png");
        pesquisar = new JButton("Pesquisar"); pesquisar.setBackground(new Color(240, 240, 240)); 
        pesquisar.setFont(new Font("SensSrif",Font.BOLD,15));
        max = new JTextField("Max"); 
        max.setFont(new Font("SensSrif",Font.BOLD,15));
        min = new JTextField("Min");
        min.setFont(new Font("SensSrif",Font.BOLD,15));
        preco = new JLabel("Preco :"); preco.setBackground(new Color(240, 240, 240));
        preco.setFont(new Font("SensSrif",Font.BOLD,15));
        notificacoes = new JButton("Notificacoes"); notificacoes.setBackground(new Color(240, 240, 240)); 
        notificacoes.setFont(new Font("SensSrif",Font.BOLD,15));
        paginaInicial = new JButton("Pagina Inicial"); paginaInicial.setBackground(new Color(240, 240, 240)); 
        paginaInicial.setFont(new Font("SensSrif",Font.BOLD,15));
        publicarAnuncio = new JButton("Publicar Anuncio"); publicarAnuncio.setBackground(new Color(240, 240, 240)); 
        publicarAnuncio.setFont(new Font("SensSrif",Font.BOLD,15));
        estatisticas = new JButton("Estatisticas"); estatisticas.setBackground(new Color(240, 240, 240)); 
        estatisticas.setFont(new Font("SensSrif",Font.BOLD,15));
        login = new JButton("Login"); login.setBackground(new Color(240, 240, 240)); 
        login.setFont(new Font("SensSrif",Font.BOLD,15));
        informacoes = new JButton("Mais Informacoes"); informacoes.setBackground(new Color(240, 240, 240));
        informacoes.setFont(new Font("SensSrif",Font.BOLD,15));
        registar = new JButton("Registar"); registar.setBackground(new Color(240, 240, 240)); 
        registar.setFont(new Font("SensSrif",Font.BOLD,15));

        preco.setBounds(20, 50, 50, 40);
        min.setBounds(75, 50, 80, 40);
        max.setBounds(170, 50, 80, 40);
        
        cb = new JComboBox();
                for (int i=0;i<bairros.length;i++){
                    cb.addItem(bairros[i]);
                }
        cb.setBounds(270,50,100,40);
        principal.add(cb);
        
        cb2 = new JComboBox();
        cb2.addItem("Venda");
        cb2.addItem("Aluguer");
        cb2.setBounds(380,50,100,40);
        principal.add(cb2);

        cb3 = new JComboBox();
        cb3.addItem("Tipo");
        cb3.addItem("Flat");
        cb3.addItem("Casa");
        cb3.setBounds(490,50,100,40);
        principal.add(cb3);
        
        pesquisar.setBounds(600, 50, 150, 40); 
        
        principal.add(preco);
        principal.add(min);
        principal.add(max);
        
        
        paginaInicial.setBounds(20, 140, 150, 40);
        publicarAnuncio.setBounds(20, 190, 150, 40);
        estatisticas.setBounds(20, 240, 150, 40); 
        login.setBounds(20, 290, 150, 40); 
        registar.setBounds(20,340, 150, 40);
        
        
         principal.add(registar);
         principal.add(pesquisar);
        
         principal.add(notificacoes);
         principal.add(paginaInicial);
         principal.add(publicarAnuncio);
         principal.add(estatisticas);
         principal.add(login);
          
        lo= new JButton("Login");
        senha = new JPasswordField("");
        senhaL = new JLabel("Senha: ");
        email = new JTextField("");
        emailL = new JLabel("Email: ");
        
        
         comprar = new JButton("<<<");
         voltar = new JButton(">>>");
         comprar.setBackground(new Color(240, 240, 240));
         voltar.setBackground(new Color(240, 240, 240));
         comprar.setBounds(500, 560, 100, 40);
         voltar.setBounds(650, 560, 100, 40);
         principal.add(comprar);
         principal.add(voltar);
        
        principal.add(email); email.setBounds(350, 400,220,30);
        email.setFont(new Font("SensSrif",Font.BOLD,15));
        
        principal.add(emailL); emailL.setBounds(290, 400,100,30);
        emailL.setFont(new Font("SensSrif",Font.BOLD,15));
        
        principal.add(senha); senha.setBounds(350, 450,220,30);
        senha.setFont(new Font("SensSrif",Font.BOLD,15));
        
        principal.add(senhaL); senhaL.setBounds(290, 450,200,30);
        senhaL.setFont(new Font("SensSrif",Font.BOLD,15));
        
        
        lo.setBounds(290, 500, 100,30);
        principal.add(lo);

       
        
        

        add(principal);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        
        Login_View2 j = new Login_View2();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      /*  
        if(e.getSource()==lo){
            DAO_Usuario u= new DAO_Usuario();
        }
*/
    }
    
}
