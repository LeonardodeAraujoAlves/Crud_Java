/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class TelaLogin extends TelaPadrao{
    private  JLabel lbl_nomeUsuario,lbl_senhaUsuario;
    private  JTextField txt_nomeUsuario,txt_senhaUsuario;
    private  JButton btn_logar;
    public TelaLogin() {
        setTitle("Tela de login");
        setSize(300, 400);
        setResizable(false);
        
        
        lbl_nomeUsuario  = new JLabel("Nome do usuario:");
        lbl_senhaUsuario = new JLabel("Senha do usuario:");
        
        txt_nomeUsuario = new JTextField("");
        txt_senhaUsuario = new JTextField("");
        
        btn_logar = new JButton("Logar");
        
        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20,100,200,50);
        
        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);
        
        btn_logar.setBounds(20, 200, 200, 30);
        
        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_logar);
        setVisible(true);
    
    }
    
    
}
