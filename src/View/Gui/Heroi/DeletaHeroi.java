package View.Gui.Heroi;

import Controller.Heroi;
import View.Gui.Menu.Menu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Classe responsável por criar a interface gráfica para realizar a remoção de herois
 * 
 *
 * @author Leonardo de Araujo Alves
 */
public class DeletaHeroi extends JFrame{

    private final JLabel lbl_titulo;
    private final JTextField txt_nomeDoHeroi;
    private final JButton btn_deletar,btn_voltar;
    
    public DeletaHeroi() {
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tela de deleção de Herois");
        setSize(400,400);
        
        lbl_titulo = new JLabel("Digite o nome do heroi que deseja deletar:");
        txt_nomeDoHeroi = new JTextField("");
        
        btn_deletar = new JButton("Deletar");
        btn_voltar = new JButton("Voltar");
        
        lbl_titulo.setBounds(90, 100, 250, 30);
        txt_nomeDoHeroi.setBounds(90, 160, 200, 30);
        
        btn_deletar.setBounds(90, 220, 200, 30);
        btn_voltar.setBounds(90, 280, 200, 30);
        
        
        btn_deletar.addActionListener((ActionEvent e) -> {
            deletar();
        });
        
        btn_voltar.addActionListener((ActionEvent e) -> {
            voltar();
        });
        
        add(lbl_titulo);
        add(txt_nomeDoHeroi);
        add(btn_deletar);
        add(btn_voltar);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
   
    /**
     * Método responsável por realizar a remoção do dado no banco de dados, atravéz 
     * do valor que foi inserido pelo usuário e pego dentro do campo de texto,
     * primeiro o valor é capturado e após isso é criado um objeto da classe heroi,
     * que chama o método deletar passando como parâmetro o valor que foi capturado 
     * no campo de texto
     * 
     * 
     * */
    private void deletar(){
       String nome = txt_nomeDoHeroi.getText();
       Heroi heroi = new Heroi(nome);
       heroi.deletar();
    }
    /**
     * 
     * Método responsável por destruir a tela atual e criar 
     * um novo objeto da classe menu, assim redirencionando 
     * para o menu da aplicação
     * 
     * */
    private void voltar(){
        this.dispose();
        Menu menu = new Menu();
    }
    
}
