package View.Gui;

import javax.swing.JButton;

/**
 *
 * @author L.A.A
 */
public class Menu extends TelaPadrao{
    
    private JButton btn_cadHeroi,btn_cadVilao,btn_cadUsr;
    
    public Menu(){
        setSize(600, 400);
        setTitle("Menu");
        
        btn_cadHeroi = new  JButton("Cadastrar heroi");
        btn_cadVilao = new  JButton("Cadastrar Vilão");
        btn_cadUsr   = new  JButton("Cadastrar Usuário");
        
        btn_cadHeroi.setBounds(20, 20, 150, 30);
        btn_cadVilao.setBounds(20, 60, 150, 30);
        btn_cadUsr.setBounds(20, 100, 150, 30);
        add(btn_cadHeroi);
        add(btn_cadVilao);
        add(btn_cadUsr);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
