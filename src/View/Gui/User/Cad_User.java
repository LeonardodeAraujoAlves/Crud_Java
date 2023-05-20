package View.Gui.User;

import View.Gui.TelaPadrao;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class Cad_User extends TelaPadrao {
     
    private final JLabel lbl_nomeUsuario,lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario,txt_senhaUsuario;
    private final JButton btn_cadastrar;

    public Cad_User() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("login.png")));
        setTitle("Tela de cadastro");
        setSize(300, 400);
        setResizable(false);
        
        lbl_nomeUsuario  = new JLabel("Nome do novo usuario:");
        lbl_senhaUsuario = new JLabel("Senha do novo usuario:");
        
        txt_nomeUsuario = new JTextField("");
        txt_senhaUsuario = new JPasswordField();
        
        btn_cadastrar = new JButton("Cadastrar");
        
        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20,100,200,50);
        
        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);
        
        btn_cadastrar.setBounds(20, 200, 200, 30);
        
        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_cadastrar);
        
        setVisible(true);
    }
    private void CadastraUsuarios(){
    String nome  = txt_nomeUsuario.getText();
    String senha = txt_senhaUsuario.getText();
    }
}
