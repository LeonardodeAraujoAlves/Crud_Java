package View.Gui.Vilao;

import Controller.Vilao;
import View.Gui.Menu.Menu;
import View.Gui.TelaPadrao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *Classe responsável por criar a interface gráfica para
 * capturar os dados inseridos nos campos de texto da interface gráfica
 * para realizar a inserção dos mesmos no banco de dados de vilões
 * @author Leonardo de Araujo Alves
 */
public class CadVilao extends TelaPadrao {

    private final JLabel lbl_nomeVilao, lbl_organizacaoVilao, lbl_inimigoVilao, lbl_alturaVilao, lbl_localprincipal, lbl_arma, lbl_mascoteVilao, lbl_quantVitimas;
    private final JTextField txt_nomeVilao, txt_organizacaoVilao, txt_inimigoVilao, txt_localprincipal, txt_arma, txt_mascoteVilao, txt_quantVitimas;
    private final JFormattedTextField txt_alturaVilao;
    //   private final JFormattedTextField txt_alturaVilao,;
    private final JButton btn_cadastrar, btn_trocar;

    public CadVilao() throws ParseException {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeVilão.png")));
        setTitle("Cadastro de Vilões");
        setResizable(false);

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

        btn_cadastrar = new JButton("Cadastrar vilão");
        btn_trocar = new JButton("Voltar");

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

        btn_cadastrar.setBounds(20, 380, 200, 40);
        btn_trocar.setBounds(40, 450, 200, 60);

        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastrarVilao();
                } catch (Exception ex) {
                    System.out.println("Ocorreu um erro ao cadastrar na base de dados: " + ex);
                }
            }
        });

        btn_trocar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    trocarDeTela();
                } catch (ParseException ex) {
                    System.out.println("Ocorreu um erro ao mudar de tela :" + e);
                }
            }
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
        add(btn_cadastrar);
        add(btn_trocar);

        setVisible(true);
    }
    //Agora temos que adicionar os eventos   
    /**
     * Método responsável por destruir a tela atual e criar 
     * um novo objeto da classe menu, assim redirencionando 
     * para o menu da aplicação
     * 
     * @throws ParseException lança ParseException que deverá ser tratada na hora 
     * de ativar o evento no botão da interface gráfica
     */
    private void trocarDeTela() throws ParseException {
        this.dispose();
        new Menu();
    }

     /**
     * Método responsável por capturar os dados inseridos nos campos 
     * da interface gráfica,criar um objeto da classe Vilao
     * passando os dados que foram capturados para oconstrutor do objeto, depois de criado o objeto
     * é realizada a chamada do método inserir, que é responsável por inserir os dados
     * do vilões no banco de dados 
     * 
     * @throws ParseException Esse método lança ParseException, do qual
     * deverá ser tratado no momento em que este método for associado a um botão
     */
    private void cadastrarVilao() throws ParseException {
        String nome = txt_nomeVilao.getText(),
                organizacao = txt_organizacaoVilao.getText(),
                inimigo = txt_inimigoVilao.getText(),
                lugaPrincipal = txt_localprincipal.getText(),
                mascote = txt_mascoteVilao.getText(),
                arma = txt_arma.getText();

        int quant_vitimas = Integer.parseInt(txt_quantVitimas.getText());
        double altura = Double.parseDouble(txt_alturaVilao.getText());

        try {
            Vilao vila = new Vilao(nome, organizacao, altura, inimigo, lugaPrincipal, arma, quant_vitimas, mascote);
            vila.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
    }
}
