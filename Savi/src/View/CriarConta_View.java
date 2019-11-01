package View;

import Model.DAO.DAO_Usuario;
import Model.VO.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CriarConta_View extends JFrame implements ActionListener{

    JButton pesquisar, notificacoes,salvar;
    static PainelFundo p1, p2;
    JPanel p3;
    JTextField busca;
    JMenu menu;
    JTextField textFields[] = new JTextField[10];
    JPasswordField ps;
    
    
    public CriarConta_View() {
        setTitle("Sistema de Arrendamentos e Vendas de Casas");
        setSize(850, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1 = new PainelFundo("src/Imagens/norte.png");
        p1.setLayout(new FlowLayout());
        p2 = new PainelFundo("src/Imagens/CriarConta.png");
        p2.setLayout(null);
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());

        
        JLabel labels[] = new JLabel[10];
        
        
        String label_Correspondencia[] = {"Nome: ", "Apelido: ", "Bairo: ", "Rua: ", "Quarteirão: ", "Username: ", "Email: ", "Senha: ", "Celular: ", "BI: "};
        String textField_Correspondencia[] = new String[10];

        ps = new JPasswordField("");
        salvar = new JButton("SALVAR");
        salvar.addActionListener(this);

        int y1, y2;
        y1 = y2 = 100;

        
        for (byte i = 0; i < 10; i++) {
            labels[i] = new JLabel(label_Correspondencia[i]);
            textFields[i] = new JTextField("");
            p2.add(labels[i]);
            p2.add(textFields[i]);
            if (i < 5) {
                labels[i].setBounds(30, y1, 80, 25);
                textFields[i].setBounds(115, y1, 100, 25);
                y1 += 65;
            } else {
                labels[i].setBounds(500, y2, 80, 25);
                textFields[i].setBounds(585, y2, 100, 25);
                y2 += 65;
            }
        }
        add(labels[9]);
        add(ps);
        labels[9].setBounds(500, 400, 80, 25);
        ps.setBounds(585, 400, 100, 25);
        p2.add(salvar);
        salvar.setBounds(350, 420, 100, 20);
        p3.setLayout(new BorderLayout());

        pesquisar = new JButton("Pesquisar");
        pesquisar.setBackground(Color.lightGray);
        pesquisar.setForeground(Color.BLACK);
        pesquisar.setFont(new Font("SensSrif", Font.BOLD, 15));
        notificacoes = new JButton("Notificacoes");
        notificacoes.setBackground(Color.lightGray);
        notificacoes.setForeground(Color.BLACK);
        notificacoes.setFont(new Font("SensSrif", Font.BOLD, 15));
        menu = new JMenu("Menu");
        busca = new JTextField(20);
        p1.add(pesquisar);
        p1.add(busca);
        p1.add(notificacoes);
        p1.add(menu);

        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.CENTER);
        add(p3);
        setVisible(true);

    }

    public static void main(String[] args) {

        CriarConta_View j = new CriarConta_View();

    }

    
    public void actionPerformed(ActionEvent e)  {
        
        if(e.getSource()==salvar){
            DAO_Usuario db= new DAO_Usuario();
            Usuario u= new Usuario();
            
            
            u.setNome(textFields[0].getText());
            u.setApelido(textFields[1].getText());
            u.setBairro(textFields[2].getText());
            u.setRua(textFields[3].getText());
            u.setQuarteirao(Integer.parseInt(textFields[4].getText()));
            u.setNomeUsuario(textFields[5].getText());
            u.setEmail(textFields[6].getText());
            u.setSenha(Integer.parseInt(textFields[7].getText()));
            u.setCelular(Integer.parseInt(textFields[8].getText()));
            u.setBi(ps.getText());
            try {
                db.inserir(u);
            } catch (Exception ex) {
                Logger.getLogger(CriarConta_View.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            setBackground(Color.BLACK);
        }
    }
}
