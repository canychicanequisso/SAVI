package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class Principa_View extends JFrame{
    private JButton comprar,voltar;
    private JLabel preco;
    private JButton pesquisar, notificacoes, paginaInicial, publicarAnuncio, estatisticas, login, informacoes, registar;
    private PainelFundo principal; 
    private JTextField max,min;
    private JComboBox cb,cb1,cb2,cb3,cb4;
    private JSpinner scasa,squarterao;
    private String bairros [] =  {"Bairro","HULENE","LAULANE","ZIMPETO","MAHOTAS","ALBAZINE","MUSEU","BAIXA","TCHUMENE","TRINFO","MAXAQUENE"};
    private JPanel prefab;
    private JScrollPane sPane;

    
    
    public Principa_View(Vector v){
         setTitle("JANELA");
         setSize(820,640);
         setLocation(250,50);
         principal = new PainelFundo("src/Imagens/esquerdo.png");
         principal.setLayout(null);
        
         
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
         
         
         comprar = new JButton("<<<");
         voltar = new JButton(">>>");
         comprar.setBackground(new Color(240, 240, 240));
         voltar.setBackground(new Color(240, 240, 240));
         comprar.setBounds(500, 560, 100, 40);
         voltar.setBounds(650, 560, 100, 40);
         principal.add(comprar);
         principal.add(voltar);
         

        JButton a[]= new JButton[v.size()];
        JPanel aux = new JPanel();
       // aux.setLayout(new GridLayout(a.length,1));
        aux.setLayout(null);
         
         
        for (int i = 0; i < a.length; i++) {
            a[i] = new JButton("");
           a[i].setBackground(new Color(241,241,241));
            PreAnuncio_View ad = (PreAnuncio_View) v.elementAt(i);
           a[i].add(ad.anuncio());
           a[i].setBounds(0, i*100, 530, 100);
            aux.setSize(530, i*100);
            aux.add(a[i]);
        }
        sPane = new JScrollPane(aux);
        sPane.createVerticalScrollBar();
        sPane.setBackground(new Color(241,241,241));
        sPane.setBounds(220, 140, 530, 400);
        sPane.setWheelScrollingEnabled(true);
        
        principal.add(sPane);

        add(principal);
        setVisible(true);
    }
}
