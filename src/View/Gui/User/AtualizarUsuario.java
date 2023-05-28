package View.Gui.User;

import Controller.Usuario;
import View.Gui.Menu.Menu;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * A classe AtualizarUsuario é responsável por criar a inerface gráfica para
 * seja possivel atualizar o cadastro dos usuários com a chamada de método
 * atualizar da classe User
 *
 * @author Leonardo de Araujo Alves
 * @version 1.0
 */
public class AtualizarUsuario extends JFrame {

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario, lbl_nomeId;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario, txt_nomeAtual;
    private final JButton btn_atualizar, btn_voltar;

    public AtualizarUsuario() {
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("login.png")));
        setTitle("Atualização de usuario");
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        lbl_nomeUsuario = new JLabel("Novo nome:");
        lbl_senhaUsuario = new JLabel("nova senha:");
        lbl_nomeId = new JLabel("Nome atual");

        txt_nomeAtual = new JTextField();
        txt_nomeUsuario = new JTextField();
        txt_senhaUsuario = new JPasswordField();

        btn_atualizar = new JButton("Atualizar");
        btn_voltar = new JButton("Voltar");

        lbl_nomeId.setBounds(20, 40, 200, 50);
        lbl_nomeUsuario.setBounds(20, 100, 200, 50);
        lbl_senhaUsuario.setBounds(20, 160, 200, 50);

        txt_nomeAtual.setBounds(20, 80, 200, 30);
        txt_nomeUsuario.setBounds(20, 140, 200, 30);
        txt_senhaUsuario.setBounds(20, 200, 200, 30);

        btn_atualizar.setBounds(20, 250, 200, 30);
        btn_voltar.setBounds(20, 300, 200, 30);

        btn_atualizar.setContentAreaFilled(false);
        btn_atualizar.setOpaque(true);
        btn_atualizar.setBackground(Color.GREEN);

        btn_voltar.setContentAreaFilled(false);
        btn_voltar.setOpaque(true);
        btn_voltar.setBackground(Color.YELLOW);

        btn_atualizar.addActionListener((ActionEvent e) -> {
            AtualizarUsuarios();
        });

        btn_voltar.addActionListener((ActionEvent e) -> {
            voltar();
        });

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(lbl_nomeId);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(txt_nomeAtual);
        add(btn_atualizar);
        add(btn_voltar);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private synchronized void AtualizarUsuarios() {
       
        String nomeuser = txt_nomeUsuario.getText();
         String nomeId = nomeuser;
        String senhauser = txt_senhaUsuario.getText();
        try {
            Usuario user = new Usuario(nomeuser, senhauser);
            user.atualizar();
        } catch (Exception e) {
        }
    }

    private void voltar() {
        this.dispose();
        Menu menu = new Menu();
    }
}

/**
 * O método ({@code AtualizarUsuarios} Pega os dados inseridos nos campos da
 * interface gráfica e armazena eles em variáveis, após isso ele cria um objeto
 * da classe Usuario e invoca o método atualizar inserindo os dados das
 * variáveis como parametros e realiza a ação de atualizar)
 *
 *
 */
/**
 *
 * O método ({@code Voltar} destroi a tela atual e cria um novo objeto da classe
 * menu)
 *
 */
