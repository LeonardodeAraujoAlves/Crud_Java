package View.Gui.Heroi;

import Controller.Heroi;
import View.Gui.Menu.Menu;
import View.Gui.TelaPadrao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author L.A.A
 */
public class AtualizaHeroi extends TelaPadrao {
    
    private final JLabel lbl_nomeHeroi,lbl_identidateHeroi,lbl_idadeHeroi,lbl_alturaHeroi,lbl_inimigoHeroi;
    private final JTextField txt_nomeHeroi,txt_identidateHeroi,txt_idadeHeroi,txt_inimigoHeroi;
    private final JFormattedTextField txt_alturaHeroi;
    private final JButton btn_atualizar,btn_voltar;
    
    public AtualizaHeroi() throws ParseException {
        
       // setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeHeroi.png")));
       
        setTitle("Cadastro de heróis");
        setResizable(false);
        
        JOptionPane.showMessageDialog(null, "Digite a identidade do Heroi para atualizar os campos!!!!!");
        
        lbl_nomeHeroi       = new JLabel("Nome do heroi:");
        lbl_identidateHeroi = new JLabel("Identidade do heroi:");
        lbl_idadeHeroi      = new JLabel("Idade do heroi:");
        lbl_alturaHeroi     = new JLabel("Altura do heroi :");
        lbl_inimigoHeroi    = new JLabel("Inimigo do heroi");
        
        txt_nomeHeroi       = new JTextField();
        txt_identidateHeroi = new JTextField();
        txt_idadeHeroi      = new JTextField();
        txt_alturaHeroi     = new JFormattedTextField(new MaskFormatter("#.##"));
        txt_inimigoHeroi    = new JTextField();
        btn_atualizar       = new JButton("Atualizar herói");
        btn_voltar           = new JButton("Voltar");
        
        lbl_identidateHeroi.setBounds(20, 20, 200, 50);
        lbl_nomeHeroi.setBounds(20, 80, 200, 50);
        lbl_idadeHeroi.setBounds(20,140,200,50);
        lbl_alturaHeroi.setBounds(20,220,200,50);
        lbl_inimigoHeroi.setBounds(20,280,200,50);
        
        txt_identidateHeroi.setBounds(20,60,200,20);
        txt_nomeHeroi.setBounds(20, 120, 200, 20);
        txt_idadeHeroi.setBounds(20,180,200,20);
        txt_alturaHeroi.setBounds(20,260,200,20);
        txt_inimigoHeroi.setBounds(20,320,200,20);
        
        btn_atualizar.setBounds(20, 360, 200, 40);
        btn_voltar.setBounds(40, 450, 200, 60);
        
        btn_atualizar.addActionListener((ActionEvent e) -> {
            Atualizar();
        });
        
        btn_voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
               
        add(lbl_nomeHeroi);
        add(txt_alturaHeroi);
        add(lbl_identidateHeroi);
        add(lbl_idadeHeroi);
        add(lbl_alturaHeroi);
        add(lbl_alturaHeroi);
        add(lbl_inimigoHeroi);
        add(lbl_inimigoHeroi);
        
        add(txt_nomeHeroi);
        add(txt_identidateHeroi);
        add(txt_idadeHeroi);
        add(txt_inimigoHeroi);
        add(btn_atualizar);
        add(btn_voltar);
        
        
        setVisible(true);
    }
    
    private void voltar() {
        this.dispose();
        Menu menu = new Menu();
    }
    private void Atualizar(){
        String nome       = txt_nomeHeroi.getText();
        String identidade = txt_identidateHeroi.getText();
        String inimigo    = txt_inimigoHeroi.getText();
        
        int idade = Integer.parseInt(txt_idadeHeroi.getText());
        double altura = Double.parseDouble(txt_alturaHeroi.getText());
        
        
        new Heroi(nome, identidade, idade, altura, inimigo).atualizar();
    }
}
