package View.Gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;


/**
 *
 * @author L.A.A
 */
public class TelaPadrao extends JFrame {

    public TelaPadrao(){
        try {
            setLayout(null);
            setSize(300, 600);
            setResizable(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        } catch (HeadlessException e) {
            System.out.println("Ocorreu um erro ao criar a janela :" + e);
        }
    }
    
}
