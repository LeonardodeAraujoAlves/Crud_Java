package View.Gui;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author L.A.A
 */
public class Menu extends JFrame{
    
    private final JButton btn_cadHeroi,btn_cadVilao,btn_cadUsr, btn_mostrarHero,btn_mostraVilao,btn_mostrarUsr;
    
    public Menu(){
        setSize(600, 400);
        setTitle("Menu");
        setLayout(null);
        
        btn_cadHeroi    = new  JButton("Cadastrar heroi");
        btn_cadVilao    = new  JButton("Cadastrar Vilão");
        btn_cadUsr      = new  JButton("Cadastrar Usuário");
        
        btn_mostrarHero = new  JButton("Mostrar heróis");
        btn_mostraVilao = new  JButton("Mostrar vilões");
        btn_mostrarUsr  = new  JButton("Mostrar usuários");
        
        btn_cadHeroi.setBounds(20, 20, 150, 30);
        btn_cadVilao.setBounds(20, 60, 150, 30);
        btn_cadUsr.setBounds(20, 100, 150, 30);
        
        btn_mostrarHero.setBounds(20, 140, 150, 30);
        btn_mostraVilao.setBounds(20, 180, 150, 30);
        btn_mostrarUsr.setBounds(20,220 , 150, 30);
        
        add(btn_cadHeroi);
        add(btn_cadVilao);
        add(btn_cadUsr);
        
        add(btn_mostrarHero);
        add(btn_mostraVilao);
        add(btn_mostrarUsr);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
