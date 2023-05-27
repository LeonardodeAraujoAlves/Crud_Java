package View.Gui.Vilao;

import Controller.Vilao;
import View.Gui.Menu.Menu;
import View.Gui.TelaPadrao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
public class AtualizaVilao extends TelaPadrao {

    private final JLabel lbl_nomeVilao, lbl_organizacaoVilao, lbl_inimigoVilao, lbl_alturaVilao, lbl_localprincipal, lbl_arma, lbl_mascoteVilao, lbl_quantVitimas;
    private final JTextField txt_nomeVilao, txt_organizacaoVilao, txt_inimigoVilao, txt_localprincipal, txt_arma, txt_mascoteVilao, txt_quantVitimas;
    private final JFormattedTextField txt_alturaVilao;
    private final JButton btn_atualizar, btn_voltar;

    public AtualizaVilao() throws ParseException {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeVilão.png")));
        setTitle("Atualização de Vilões");
        setResizable(false);
        setLayout(null);

        JOptionPane.showMessageDialog(null, "Digite o nome do vilão para atualizar os campos!!!!!");

        lbl_nomeVilao = new JLabel("Nome do vilão :");
        lbl_organizacaoVilao = new JLabel("Organização do vilão :");
        lbl_alturaVilao = new JLabel("Altura do vilão :");
        lbl_inimigoVilao = new JLabel("Inimigo do vilão :");
        lbl_localprincipal = new JLabel("Local principal :");
        lbl_arma = new JLabel("Arma do vilão :");
        lbl_mascoteVilao = new JLabel("Mascote do vilão :");
        lbl_quantVitimas = new JLabel("Quantidade de vitimas :");

        txt_nomeVilao = new JTextField();
        txt_organizacaoVilao = new JTextField();
        txt_inimigoVilao = new JTextField();
        txt_localprincipal = new JTextField();
        txt_arma = new JTextField();
        txt_mascoteVilao = new JTextField();
        txt_quantVitimas = new JTextField();
        txt_alturaVilao = new JFormattedTextField(new MaskFormatter("#.##"));

        btn_atualizar = new JButton("Atualizar vilão");
        btn_voltar = new JButton("Voltar");

        lbl_nomeVilao.setBounds(20, 20, 200, 50);
        lbl_organizacaoVilao.setBounds(20, 60, 200, 50);
        lbl_alturaVilao.setBounds(20, 100, 200, 50);
        lbl_localprincipal.setBounds(20, 140, 200, 50);
        lbl_arma.setBounds(20, 180, 200, 50);
        lbl_inimigoVilao.setBounds(20, 220, 200, 50);
        lbl_mascoteVilao.setBounds(20, 260, 200, 50);
        lbl_quantVitimas.setBounds(20, 300, 200, 50);

        txt_nomeVilao.setBounds(20, 55, 200, 20);
        txt_organizacaoVilao.setBounds(20, 95, 200, 20);
        txt_alturaVilao.setBounds(20, 135, 200, 20);
        txt_localprincipal.setBounds(20, 175, 200, 20);
        txt_arma.setBounds(20, 215, 200, 20);
        txt_inimigoVilao.setBounds(20, 255, 200, 20);
        txt_mascoteVilao.setBounds(20, 295, 200, 20);
        txt_quantVitimas.setBounds(20, 335, 200, 20);

        btn_atualizar.setBounds(20, 380, 200, 40);
        btn_voltar.setBounds(40, 450, 200, 60);

        btn_atualizar.addActionListener((ActionEvent e) -> {
            Atualizar();
        });

        btn_voltar.addActionListener((ActionEvent e) -> {
            Voltar();
        });
        //label
        add(lbl_nomeVilao);
        add(lbl_organizacaoVilao);
        add(lbl_alturaVilao);
        add(lbl_localprincipal);
        add(lbl_arma);
        add(lbl_inimigoVilao);
        add(lbl_mascoteVilao);
        add(lbl_quantVitimas);
        //campo de texto
        add(txt_nomeVilao);
        add(txt_organizacaoVilao);
        add(txt_alturaVilao);
        add(txt_localprincipal);
        add(txt_arma);
        add(txt_inimigoVilao);
        add(txt_mascoteVilao);
        add(txt_quantVitimas);
        //botão
        add(btn_atualizar);
        add(btn_voltar);

        setVisible(true);
    }
    //Agora temos que adicionar os eventos   

    private void Voltar() {
        this.dispose();
        Menu menu = new Menu();
    }

    private void Atualizar() {
        String nome = txt_nomeVilao.getText();
        String organizacao = txt_organizacaoVilao.getText();
        String inimigo = txt_inimigoVilao.getText();
        String lugaPrincipal = txt_localprincipal.getText();
        String mascote = txt_mascoteVilao.getText();
        String arma = txt_arma.getText();

        int quant_vitimas = Integer.parseInt(txt_quantVitimas.getText());
        double altura = Double.parseDouble(txt_alturaVilao.getText());
        try {
            Vilao vilao = new Vilao(nome, organizacao, altura, inimigo, lugaPrincipal, arma, quant_vitimas, mascote);
            vilao.atualizar();

        } catch (Exception e) {
        }
    }
}
