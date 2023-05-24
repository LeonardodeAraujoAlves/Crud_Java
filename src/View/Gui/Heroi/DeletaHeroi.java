package View.Gui.Heroi;

import Controller.Heroi;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author L.A.A
 */
public class DeletaHeroi extends JFrame{

    private final JLabel lbl_titulo;
    private final JTextField txt_nomeDoHeroi;
    private final JButton btn_deletar,btn_voltar;
    
    public DeletaHeroi() {
        setLayout(null);
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
        
        add(lbl_titulo);
        add(txt_nomeDoHeroi);
        add(btn_deletar);
        add(btn_voltar);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    private void deletar(){
        Heroi heroi = new Heroi();
        heroi.deletar();
    }
    
}
