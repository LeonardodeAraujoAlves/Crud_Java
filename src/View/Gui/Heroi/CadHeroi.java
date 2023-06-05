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
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Classe responsável por criar uma interface gráfica
 * e capturar os dados dos campos de texto para inserir posteriormente 
 * no 
 * banco de dados
 *
 * @author Leonardo de Araujo Alves
 */
public class CadHeroi extends TelaPadrao{
    
    private final JLabel lbl_nomeHeroi,lbl_identidateHeroi,lbl_idadeHeroi,lbl_alturaHeroi,lbl_inimigoHeroi;
    private final JTextField txt_nomeHeroi,txt_identidateHeroi,txt_idadeHeroi,txt_inimigoHeroi;
    private final JFormattedTextField txt_alturaHeroi;
    private final JButton btn_cadastrar,btn_troca;
   
    public CadHeroi() throws ParseException {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeHeroi.png")));
        setTitle("Cadastro de heróis");
        setResizable(false);
        
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
        btn_cadastrar       = new JButton("Cadastrar herói");
        btn_troca           = new JButton("Voltar");
        
        lbl_nomeHeroi.setBounds(20, 20, 200, 50);
        lbl_identidateHeroi.setBounds(20, 80, 200, 50);
        lbl_idadeHeroi.setBounds(20,140,200,50);
        lbl_alturaHeroi.setBounds(20,220,200,50);
        lbl_inimigoHeroi.setBounds(20,280,200,50);
        
        txt_nomeHeroi.setBounds(20,60,200,20);
        txt_identidateHeroi.setBounds(20, 120, 200, 20);
        txt_idadeHeroi.setBounds(20,180,200,20);
        txt_alturaHeroi.setBounds(20,260,200,20);
        txt_inimigoHeroi.setBounds(20,320,200,20);
        
        btn_cadastrar.setBounds(20, 360, 200, 40);
        btn_troca.setBounds(40, 450, 200, 60);
        
        btn_cadastrar.addActionListener((ActionEvent e) -> {
            try{
                cadastrarHeroi();
            }catch(ParseException ex){
                System.out.println("Ocorreu um erro ao cadastrar no banco de dados :" + e);
            }
        });
        
        btn_troca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    trocaDeTela();
                } catch (ParseException ex) {
                    System.out.println("Ocorreu um erro ao mudar de tela :" + e);
                }
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
        add(btn_cadastrar);
        add(btn_troca);
        
        
        setVisible(true);
    }
    
    /**
     * Método responsável por destruir a tela atual e criar 
     * um novo objeto da classe menu, assim redirencionando 
     * para o menu da aplicação
     * 
     * @throws ParseException lança ParseException que deverá ser tratada na hora 
     * de ativar o evento no botão da interface gráfica
     */
    private void trocaDeTela() throws ParseException{
        this.dispose();
        Menu menu = new Menu();
    }
    
    /**
     * Método responsável por capturar os dados inseridos nos campos 
     * da interface gráfica, realizar conversões nos campos idade e altura
     * para os tipos de dados corretos e criar um objeto da classe Heroi
     * passando os dados no construtor do objeto.Depois de criado o objeto
     * é realizada a chamada do método inserir, que é responsável por inserir os dados
     * supracitados no banco de dados
     * 
     * @throws ParseException Esse método lança ParseException, do qual
     * deverá ser tratado no momento em que este método for associado a um botão
     */
    private void cadastrarHeroi()throws ParseException{
        String nome       = txt_nomeHeroi.getText(),
               identidade = txt_identidateHeroi.getText(),
               inimigo    = txt_inimigoHeroi.getText();
        
        int idade = Integer.parseInt(txt_idadeHeroi.getText());
        double altura = Double.parseDouble(txt_alturaHeroi.getText());
       
        try {
            Heroi hero = new Heroi(nome, identidade, idade, altura, inimigo);
            hero.inserir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o evento :" + e);
        }
        
        
    }
    
}
