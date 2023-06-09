package View.Gui.User;

import Controller.Usuario;
import View.Gui.Login.TelaLogin;
import View.Gui.TelaPadrao;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe responsável por criar uma interface gráfica
 * e capturar os dados dos campos de texto para inserir posteriormente 
 * no 
 * banco de dados os dados de usuários
 *
 * @author Leonardo de Araujo Alves
 */
public class Cad_User extends TelaPadrao {
     
    private final JLabel lbl_nomeUsuario,lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario,txt_senhaUsuario;
    private final JButton btn_cadastrar,btn_voltar;

    public Cad_User() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("login.png")));
        setTitle("Tela de cadastro");
        setSize(300, 400);
        setResizable(false);
        
        lbl_nomeUsuario  = new JLabel("Nome do novo usuario:");
        lbl_senhaUsuario = new JLabel("Senha do novo usuario:");
        
        txt_nomeUsuario = new JTextField();
        txt_senhaUsuario = new JPasswordField();
        
        btn_cadastrar = new JButton("Cadastrar");
        btn_voltar = new JButton("Voltar");
        
        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20,100,200,50);
        
        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);
        
        btn_cadastrar.setBounds(20, 200, 200, 30);
        btn_voltar.setBounds(20, 240, 200, 30);
        
        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastraUsuarios();
            }
        });
        
        btn_voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        
        btn_cadastrar.setContentAreaFilled(false);
        btn_cadastrar.setOpaque(true);
        btn_cadastrar.setBackground(Color.GREEN);
        
        btn_voltar.setContentAreaFilled(false);
        btn_voltar.setOpaque(true);
        btn_voltar.setBackground(Color.YELLOW);
        
        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_cadastrar);
        add(btn_voltar);
        
        setVisible(true);
    }
    
     /**
     * Método responsável por capturar os dados inseridos nos campos 
     * da interface gráfica, criar um objeto da classe Usuario
     * passando os dados no construtor do objeto , depois de criado o objeto
     * é realizada a chamada do método inserir, desta forma inserindo os dados
     * dos usuarios no banco de dados
     *  
     * 
     * @throws ParseException Esse método lança ParseException, do qual
     * deverá ser tratado no momento em que este método for associado a um botão
     */
    private synchronized void CadastraUsuarios(){
    String nomeuser  = txt_nomeUsuario.getText();
    String senhauser = txt_senhaUsuario.getText();
    
        try {
            Usuario user = new Usuario(nomeuser, senhauser);
            user.inserir();
        } catch (Exception e) {
        }
    }
    
     
    /**
     * Método responsável por destruir a tela atual e criar 
     * um novo objeto da classe menu, assim redirencionando 
     * para o menu da aplicação
     * 
     * @throws ParseException lança ParseException que deverá ser tratada na hora 
     * de ativar o evento no botão da interface gráfica
     */
    
    private void voltar ( ){
        this.dispose();
        TelaLogin login = new TelaLogin();
    }
}
