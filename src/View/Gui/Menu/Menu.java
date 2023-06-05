package View.Gui.Menu;

import Controller.Heroi;
import Controller.Usuario;
import Controller.Vilao;
import View.Gui.Heroi.AtualizaHeroi;
import View.Gui.User.Cad_User;
import View.Gui.Vilao.CadVilao;
import View.Gui.Heroi.CadHeroi;
import View.Gui.Heroi.DeletaHeroi;
import View.Gui.Login.TelaLogin;
import View.Gui.User.AtualizarUsuario;
import View.Gui.User.DeletaUsuario;
import View.Gui.Vilao.AtualizaVilao;
import View.Gui.Vilao.DeletaVilao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Esta classe é responsável por criar a interface gráfica
 * do menu da aplicação e fazer os redirecionamentos para os
 * locais solicitados
 *
 * @author Leonardo de Araujo Alves
 */
public class Menu extends JFrame {

    private final JButton btn_cadHeroi, btn_cadVilao, btn_cadUsr;
    private final JButton btn_mostrarHero, btn_mostraVilao, btn_mostrarUsr;
    private final JButton btn_alteraHero, btn_alteraVilao, btn_alteraUsr;
    private final JButton btn_deletaHero, btn_deletaVilao, btn_deletaUsr, btn_sair;

    public Menu() {
        setSize(500, 400);
        setTitle("Menu");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
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

        btn_cadVilao.addActionListener((ActionEvent e) -> {
            try {
                CadVilao();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_alteraVilao.addActionListener((ActionEvent e) -> {
            atualizaVilao();
        });

        btn_deletaVilao.addActionListener((ActionEvent e) -> {
            deletaVilao();
        });

        btn_mostraVilao.addActionListener((ActionEvent e) -> {
            try {
                mostrarVilao();
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_cadHeroi.addActionListener((ActionEvent e) -> {
            try {
                cadHeroi();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_mostrarHero.addActionListener((ActionEvent e) -> {
            mostrarHeroi();
        });

        btn_alteraHero.addActionListener((ActionEvent e) -> {
            AtualizaHeroi();
        });
        
        btn_deletaHero.addActionListener((ActionEvent e) -> {
            deletarHeroi();
        });

        btn_cadUsr.addActionListener((ActionEvent e) -> {
            try {
                CadUsr();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao executar a ação :" + ex);
            }
        });

        btn_mostrarUsr.addActionListener((ActionEvent e) -> {
            mostrarUsuario();
        });

        btn_alteraUsr.addActionListener((ActionEvent e) -> {
            AtualizaUsuario();
        });

        btn_deletaUsr.addActionListener((ActionEvent e) -> {
            deletarUsuario();
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

    //heroi
    
    /**
     * Metodo responsável por destruir a interface gráfica atual
     * e criar um objeto da classe CadHerois e redirecionar para 
     * a tela de cadastro de herois
     * @throws ParseException 
     */
    private void cadHeroi() throws ParseException {
        this.dispose();
        CadHeroi cadHeroi = new CadHeroi();
    }

    /**
     * Método responsável por criar um objeto da classe 
     * Heroi para mostrar atravéz de uma interface gráfica 
     * os cadastros que foram realizados
     */
    private void mostrarHeroi() {
        Heroi exibirHeroi = new Heroi();
        exibirHeroi.mostrar();
    }
    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe AtualizaHeroi, desta forma redirecionando
     * a aplicação para a tela de atualização de herois
     */
    private void AtualizaHeroi() {

        try {
            this.dispose();
            AtualizaHeroi atualizaHeroi = new AtualizaHeroi();
        } catch (ParseException ex) {
            System.out.println("Ocorreu um erro ao tentar executar a ação :" + ex);
        }
    }

    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe DeletaHeroi, desta forma redirecionando
     * a aplicação para a tela de remoção de herois
     */
    
    private void deletarHeroi() {
        this.dispose();
        DeletaHeroi deletar = new DeletaHeroi();
    }

    //vilao
    
     /**
     * Metodo responsável por destruir a interface gráfica atual
     * e criar um objeto da classe CadVilao, e redirecionar para 
     * a tela de cadastro de vilões
     * @throws ParseException 
     */
    private void CadVilao() throws ParseException {
        this.dispose();
        CadVilao cadVilao = new CadVilao();
    }

    
    /**
     * Método responsável por criar um objeto da classe 
     * Vilao para mostrar atravéz de uma interface gráfica 
     * os cadastros que foram realizados
     */
    private void mostrarVilao() throws ParseException {
        Vilao vilao = new Vilao();
        vilao.mostrar();
    }
    
    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe AtualizaVilao, desta forma redirecionando
     * a aplicação para a tela de atualização de vilões
     */
    private void atualizaVilao() {
        this.dispose();
        try {
            AtualizaVilao vilao = new AtualizaVilao();
        } catch (ParseException ex) {
            System.out.println("Ocorreu um erro ao tentar executar a ação solicitada : " + ex);
        }
    }

    
    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe DeletaVilao, desta forma redirecionando
     * a aplicação para a tela de remoção de herois
     */
    
    private void deletaVilao() {
        this.dispose();
        DeletaVilao deletar = new DeletaVilao();
    }

    //usuario
    /**
     * Metodo responsável por destruir a interface gráfica atual
     * e criar um objeto da classe Cad_User, e redirecionar para 
     * a tela de cadastro de usuários
     * @throws ParseException 
     */
    private void CadUsr() throws ParseException {
        this.dispose();
        Cad_User cadastraUsuario = new Cad_User();
    }

    /**
     * Método responsável por criar um objeto da classe 
     * Usuario para mostrar atravéz de uma interface gráfica 
     * os cadastros que foram realizados
     */
    private void mostrarUsuario() {
        Usuario user = new Usuario();
        user.mostrar();
    }

    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe DeletaUsuario, desta forma redirecionando
     * a aplicação para a tela de remoção de usuários
     */
    
    private void deletarUsuario() {
        this.dispose();
        DeletaUsuario user = new DeletaUsuario();
    }

    
    /**
     * Método responsável por destruir a interface gráfica atual
     * e criar um objeto da classe AtualizaVilao, desta forma redirecionando
     * a aplicação para a tela de atualização de vilões
     */
    
    private void AtualizaUsuario() {
        this.dispose();
        AtualizarUsuario atualizarUsuario = new AtualizarUsuario();
    }

    //função da tela
    
    /**
     * Método responsável por destruir a interface gráfica atual 
     * e criar um objeto da classe TelaLogin, fazendo com que a aplicação
     * volte para a tela inicial que é a tela de login
     */
    private void sair() {
        this.dispose();
        TelaLogin telaLogin = new TelaLogin();
    }
}
