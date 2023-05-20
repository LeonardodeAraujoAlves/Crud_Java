/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Gui.Login;

import Model.Autenticacao;
import View.Gui.Menu;
import View.Gui.TelaPadrao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class TelaLogin extends TelaPadrao {

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario;
    private final JButton btn_logar;

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

        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20, 100, 200, 50);

        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);

        btn_logar.setBounds(20, 200, 200, 30);

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

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_logar);

        setVisible(true);

    }

    //Pegando os valores dos Campos
    private void Logar() throws ParseException {
        String nome = txt_nomeUsuario.getText();
        String senha = txt_senhaUsuario.getText();

        Autenticacao autent = new Autenticacao(nome, senha);

        autent.Acessa(nome, senha);

        if (autent.Acessa(nome, senha) == true) {
            this.dispose();
            Menu menu = new Menu();

        }

    }
}
