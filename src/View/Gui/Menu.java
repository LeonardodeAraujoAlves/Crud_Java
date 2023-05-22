package View.Gui;

import View.Gui.User.Cad_User;
import View.Gui.Vilao.CadVilao;
import View.Gui.Heroi.CadHeroi;
import View.Gui.Login.TelaLogin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author L.A.A
 */
public class Menu extends JFrame {

    private final JButton btn_cadHeroi, btn_cadVilao, btn_cadUsr;
    private final JButton btn_mostrarHero, btn_mostraVilao, btn_mostrarUsr;
    private final JButton btn_alteraHero, btn_alteraVilao, btn_alteraUsr;
    private final JButton btn_deletaHero, btn_deletaVilao, btn_deletaUsr,btn_sair;

    public Menu() {
        setSize(500, 400);
        setTitle("Menu");
        setLayout(null);
        setResizable(false);

        btn_cadHeroi = new JButton("Cadastrar heroi");
        btn_cadVilao = new JButton("Cadastrar Vilão");
        btn_cadUsr = new JButton("Cadastrar Usuário");

        btn_mostrarHero = new JButton("Mostrar heróis");
        btn_mostraVilao = new JButton("Mostrar vilões");
        btn_mostrarUsr = new JButton("Mostrar usuários");

        btn_alteraHero = new JButton("Atualizar heroi");
        btn_alteraVilao = new JButton("Atualizar vilão");
        btn_alteraUsr = new JButton("Atualizar usuário");

        btn_deletaHero = new JButton("Deletar Heroi");
        btn_deletaVilao = new JButton("Deletar Vilão");
        btn_deletaUsr = new JButton("Deletar usuário");
        btn_sair = new JButton("Sair");
        
        
        btn_cadHeroi.setBounds(20, 20, 150, 30);
        btn_cadVilao.setBounds(20, 60, 150, 30);
        btn_cadUsr.setBounds(20, 100, 150, 30);
        
        
        btn_mostrarHero.setBounds(20, 140, 150, 30);
        btn_mostraVilao.setBounds(20, 180, 150, 30);
        btn_mostrarUsr.setBounds(20, 220, 150, 30);

        btn_alteraHero.setBounds(300, 20, 150, 30);
        btn_alteraVilao.setBounds(300, 60, 150, 30);
        btn_alteraUsr.setBounds(300, 100, 150, 30);

        btn_deletaHero.setBounds(300, 140, 150, 30);
        btn_deletaVilao.setBounds(300, 180, 150, 30);
        btn_deletaUsr.setBounds(300, 220, 150, 30);
        btn_sair.setBounds(300, 300, 150, 30);//(20, 380, 250, 30);
        
        btn_sair.setContentAreaFilled(false);
        btn_sair.setOpaque(true);
        btn_sair.setBackground(Color.RED);
        
        btn_cadHeroi.addActionListener((ActionEvent e) -> {
            try {
                cadHeroi();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_cadVilao.addActionListener((ActionEvent e) -> {
            try {
                CadVilao();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });
        
        btn_cadUsr.addActionListener((ActionEvent e) -> {
            try {
                CadUsr();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });
        
        btn_mostraVilao.addActionListener((ActionEvent e) -> {
            try {
                mostrarVilao();
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        btn_sair.addActionListener((ActionEvent e) -> {
            sair();
        });

        add(btn_cadHeroi);
        add(btn_cadVilao);
        add(btn_cadUsr);
       
        add(btn_mostrarHero);
        add(btn_mostraVilao);
        add(btn_mostrarUsr);

        add(btn_alteraHero);
        add(btn_alteraVilao);
        add(btn_alteraUsr);

        add(btn_deletaHero);
        add(btn_deletaVilao);
        add(btn_deletaUsr);

        add(btn_sair);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void cadHeroi() throws ParseException {
        this.dispose();
        CadHeroi cadHeroi = new CadHeroi();
    }

    private void CadVilao() throws ParseException {
        this.dispose();
        CadVilao cadVilao = new CadVilao();
    }
    
    private void CadUsr() throws ParseException {
        this.dispose();
        Cad_User cadastraUsuario = new Cad_User();
    }
    private void sair(){
        this.dispose();
        TelaLogin telaLogin = new TelaLogin();
    }
    private void mostrarVilao()throws ParseException{
      //  Vilao vila = new Vilao(nome, organizacao, ABORT, inimigo, lugaPrincipal, arma, FRAMEBITS, mascote);
    }

}
