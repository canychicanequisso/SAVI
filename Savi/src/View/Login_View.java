package View;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
//.*;
public class Login_View extends JFrame {
    
    JButton pesquisar, notificacoes, paginaInicial, publicarAnuncio, estatisticas, login, informacoes;
    JPanel p4;
     static PainelFundo p1, p2,p3; 
    JTextField busca, email;
    JPasswordField senha;
    JLabel senhaL,emailL;
    JMenu menu;
    
    
    public Login_View() {
        
        
        setTitle("Sistema de Arrendamentos e Vendas de Casas");
        setSize(850,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1 = new PainelFundo("src/Imagens/norte.png");
        p2 = new PainelFundo("src/Imagens/esquerdo.png");
        p3 = new PainelFundo("src/Imagens/LOGIN.png");
        senha = new JPasswordField("");
        senhaL = new JLabel("Senha: ");
        email = new JTextField("");
        emailL = new JLabel("Email: ");
        
        p4 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(4,1,0,50)); 
       
        p4.setLayout(new BorderLayout());
        pesquisar = new JButton("Pesquisar"); pesquisar.setBackground(Color.lightGray);pesquisar.setForeground(Color.BLACK); 
        pesquisar.setFont(new Font("SensSrif",Font.BOLD,15));
        notificacoes = new JButton("Notificacoes"); notificacoes.setBackground(Color.lightGray); notificacoes.setForeground(Color.BLACK);
        notificacoes.setFont(new Font("SensSrif",Font.BOLD,15));
        paginaInicial = new JButton("Pagina Inicial"); paginaInicial.setBackground(Color.lightGray); paginaInicial.setForeground(Color.BLACK);
        paginaInicial.setFont(new Font("SensSrif",Font.BOLD,13));
        publicarAnuncio = new JButton("Publicar Anuncio"); publicarAnuncio.setBackground(Color.lightGray); publicarAnuncio.setForeground(Color.BLACK);
        publicarAnuncio.setFont(new Font("SensSrif",Font.BOLD,13));
        estatisticas = new JButton("Estatisticas"); estatisticas.setBackground(Color.lightGray); estatisticas.setForeground(Color.BLACK);
        estatisticas.setFont(new Font("SensSrif",Font.BOLD,13));
        login = new JButton("Login"); login.setBackground(Color.lightGray); login.setForeground(Color.BLACK); 
        login.setFont(new Font("SensSrif",Font.BOLD,13));
        informacoes = new JButton("Mais Informacoes"); informacoes.setBackground(Color.lightGray); informacoes.setForeground(Color.BLACK);
        informacoes.setFont(new Font("SensSrif",Font.BOLD,13));
        menu = new JMenu("Menu");
        busca = new JTextField(20);
        p1.add(pesquisar);
        p1.add(busca);
        p1.add(notificacoes);
        p1.add(menu);
        
        p2.add(paginaInicial);
        p2.add(publicarAnuncio);
        p2.add(estatisticas);
        p2.add(login);
        
        p3.setLayout(null);
        p3.add(email); email.setBounds(240, 300,200,20);
        p3.add(emailL); emailL.setBounds(190, 300,100,20);
        p3.add(senha); senha.setBounds(240, 350,200,20);
        p3.add(senhaL); senhaL.setBounds(190, 350,200,20);
        
        p4.add(p1, BorderLayout.NORTH);
        p4.add(p2, BorderLayout.WEST);
        p4.add(p3, BorderLayout.CENTER);
        
        add(p4);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        Login_View j = new Login_View();
        
    }
}

