/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Gui.User;

import Controller.Usuario;
import Controller.Vilao;
import View.Gui.Menu.Menu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class DeletaUsuario extends JFrame {
    
    private final JLabel lbl_titulo;
    private final JTextField txt_nomeDoUsuario;
    private final JButton btn_deletar,btn_voltar;
    
    public DeletaUsuario() {
        setLayout(null);
        setResizable(false);
        setTitle("Tela de deleção de Vilões");
        setSize(400,400);
        
        lbl_titulo = new JLabel("Digite o nome do vilão que deseja deletar:");
        txt_nomeDoUsuario = new JTextField("");
        
        btn_deletar = new JButton("Deletar");
        btn_voltar = new JButton("Voltar");
        
        lbl_titulo.setBounds(90, 100, 250, 30);
        txt_nomeDoUsuario.setBounds(90, 160, 200, 30);
        
        btn_deletar.setBounds(90, 220, 200, 30);
        btn_voltar.setBounds(90, 280, 200, 30);
        
        
        btn_deletar.addActionListener((ActionEvent e) -> {
            deletar();
        });
        
        btn_voltar.addActionListener((ActionEvent e) -> {
            voltar();
        });
        
        add(lbl_titulo);
        add(txt_nomeDoUsuario);
        add(btn_deletar);
        add(btn_voltar);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void deletar(){
       String nome = txt_nomeDoUsuario.getText();
       System.out.println(nome);
       Usuario usuario = new Usuario();
       usuario.deletar(nome);
    }
    
    private void voltar(){
        this.dispose();
        Menu menu = new Menu();
    }
    
    
    
}
