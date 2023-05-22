/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Gui.Login;

import Model.Autenticacao;
import View.Gui.Menu;
import View.Gui.TelaPadrao;
import View.Gui.User.Cad_User;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class TelaLogin extends TelaPadrao implements Runnable{

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario;
    private final JButton btn_logar,btn_cadastrar;

    public TelaLogin() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("login.png")));
        setTitle("Tela de login");
        setSize(300, 400);
        setResizable(false);

        lbl_nomeUsuario = new JLabel("Nome do usuario:");
        lbl_senhaUsuario = new JLabel("Senha do usuario:");

        txt_nomeUsuario = new JTextField("");
        txt_senhaUsuario = new JPasswordField();

        btn_logar = new JButton("Logar");
        btn_cadastrar = new JButton("Cadastrar novo usuário");
        
        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20, 100, 200, 50);

        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);

        btn_logar.setBounds(20, 200, 200, 30);
        btn_cadastrar.setBounds(20, 260, 200, 30);
        
        btn_logar.setContentAreaFilled(false);
        btn_logar.setOpaque(true);
        btn_logar.setBackground(Color.GREEN);

        btn_cadastrar.setContentAreaFilled(false);
        btn_cadastrar.setOpaque(true);
        btn_cadastrar.setBackground(Color.YELLOW);
        
        btn_logar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Logar();

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a ação :" + ex);
                }
            }
        });
        
        btn_cadastrar.addActionListener((ActionEvent e) -> {
            try {
                CadastrarUsuario();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao carregar a tela de cadastro :" + ex);
            }
        });

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_logar);
        add(btn_cadastrar);
        setVisible(true);

    }

    //Pegando os valores dos Campos
    private  synchronized void Logar() throws ParseException {
        String nome = txt_nomeUsuario.getText();
        String senha = txt_senhaUsuario.getText();

        Autenticacao autent = new Autenticacao(nome, senha);

        //autent.Acessa(nome, senha);

        if (autent.Acessa(nome, senha) == true) {
            this.dispose();
            Menu menu = new Menu();

        }

    }
    
    private void CadastrarUsuario() throws ParseException {
        this.dispose();
        Cad_User cadastraUsuario = new Cad_User();
    }
    @Override
    public void run() {
        try {
            this.Logar();
        } catch (ParseException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
