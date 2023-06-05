package View.Gui.Login;

import Model.Autenticacao;
import View.Gui.Menu.Menu;
import View.Gui.TelaPadrao;
import View.Gui.User.Cad_User;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *Esta classe é responsável por criar uma interface gráfica
 *para que o usuário efetue o login na aplicação ou crie um 
 *novo login caso não possua
 * @author Leonardo de Araujo Alves
 */
public class TelaLogin extends TelaPadrao implements Runnable{

    private final JLabel lbl_nomeUsuario, lbl_senhaUsuario;
    private final JTextField txt_nomeUsuario, txt_senhaUsuario;
    private final JButton btn_logar,btn_cadastrar;

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
        btn_cadastrar = new JButton("Cadastrar novo usuário");
        
        lbl_nomeUsuario.setBounds(20, 40, 200, 50);
        lbl_senhaUsuario.setBounds(20, 100, 200, 50);

        txt_nomeUsuario.setBounds(20, 80, 200, 30);
        txt_senhaUsuario.setBounds(20, 140, 200, 30);

        btn_logar.setBounds(20, 200, 200, 30);
        btn_cadastrar.setBounds(20, 260, 200, 30);
        
        btn_logar.setContentAreaFilled(false);
        btn_logar.setOpaque(true);
        btn_logar.setBackground(Color.GREEN);

        btn_cadastrar.setContentAreaFilled(false);
        btn_cadastrar.setOpaque(true);
        btn_cadastrar.setBackground(Color.YELLOW);
        
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
        
        btn_cadastrar.addActionListener((ActionEvent e) -> {
            try {
                CadastrarUsuario();
            } catch (ParseException ex) {
                System.out.println("Ocorreu um erro ao carregar a tela de cadastro :" + ex);
            }
        });

        add(lbl_nomeUsuario);
        add(lbl_senhaUsuario);
        add(txt_nomeUsuario);
        add(txt_senhaUsuario);
        add(btn_logar);
        add(btn_cadastrar);
        setVisible(true);

    }

 /**
 *  Este método é responsável por realizar a autenticação do usuário no sistema.
 *   Ele obtém o nome e a senha do usuário a partir dos campos de texto da interface gráfica,
 *  cria um objeto Autenticacao e chama o método Acessa para verificar se as credenciais são válidas.
 *  Caso a autenticação seja bem sucedida, o usuário é redirecionado para a tela do menu principal.
 *  @throws ParseException.
 */ 
    
    /**
     *  Esté método é responsável por realizar a autenticação do usuário no sistema
     *  ele captura os dados nos campos de texto da interface gráfica, cria um objeto
     *  da classe Autenticacao passando como parâmetro os dados que foram capturados
     *  , em sequida chama o método autentica que vai realizar a verificação da existência 
     *  dos dados no banco de dados, caso os dados existam o usuário será redirecionado para o 
     *  menu da aplicação
     *  @throws ParseException .
     */
    //Pegando os valores dos Campos
    private  synchronized void Logar() throws ParseException {
        String nome = txt_nomeUsuario.getText();
        String senha = txt_senhaUsuario.getText();

        Autenticacao autent = new Autenticacao(nome, senha);

        //autent.Acessa(nome, senha);

        if (autent.Acessa(nome, senha) == true) {
            this.dispose();
            Menu menu = new Menu();

        }

    }
    
    /**
     * Este método é responsável por destruir a interface gráfica 
     * atual e criar um objeto da classe Cad_User, desta forma redirecionando 
     * o usuário para a tela de cadastro de usuários.
     * @throws ParseException 
     */
    private void CadastrarUsuario() throws ParseException {
        this.dispose();
        Cad_User cadastraUsuario = new Cad_User();
    }
    @Override
    public void run() {
        try {
            this.Logar();
        } catch (ParseException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
