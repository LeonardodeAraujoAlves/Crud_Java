package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * Esta classe é responsável por representar um herói dentro do sistema de cadastro
 * Ela estende a classe BDObject para permitir a persistência em banco de dados
 * Possui métodos para inserir, atualizar, deletar e mostrar informações de um herói no banco de dados
 * @author Leonardo de Araujo Alves
 * @version 1.6
 */
public class Heroi extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String identidade;
    private int idade;
    private double altura;
    private String inimigo;

    public Heroi(String nomeH, String identidadeH, int idadeH, double alturaH, String inimigoH) {
        nome = nomeH;
        identidade = identidadeH;
        idade = idadeH;
        altura = alturaH;
        inimigo = inimigoH;
    }
    
    
    public Heroi(String nomeH){
        nome = nomeH;
    }
    
    
    public Heroi() {
    }
    
    /**
     * Método responsável por retornar um PreparedStatement com a query 
     * de inserção dos dados de um herói no banco de dados
     * @return  PreparedStatement com a query de inserção
     */
   @Override
   public PreparedStatement statementInserir() {
        String query = "INSERT INTO HEROI VALUES (?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome);
            pst.setString(2, identidade);
            pst.setInt(3, idade);
            pst.setDouble(4, altura);
            pst.setString(5, inimigo);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao executar a operação de inserção :" + ex);
        }
        return pst;
    }
   
   /**
    * Método responsável por retornar um PrearedStatement com a query
    * de remoção dos dados de um herói no banco de dados
    * @return  PreparedStatement com a query de remoção
    */

    @Override
    public PreparedStatement statementDeletar() {
            String query = "DELETE FROM HEROI WHERE NOME_HEROI = ?";
            PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
        return pst;
    }
    /**
     * Método responsável por retornar um PreparedStatement com a query
     * de atualização dos dados de um heroi no banco de dados
     * @return PreparedStatement com a query de atualização dos dados
     */

    @Override
    public PreparedStatement statementAtualizar() {
            String query = "UPDATE HEROI SET nome_heroi = ?, idade_heroi= ?, altura_heroi = ?, inimigo_heroi= ? WHERE identidade_heroi = ?" ;
            PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.setDouble(3, altura);
            pst.setString(4, inimigo);
            pst.setString(5, identidade);
            
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao atualizar a base de dados :" + e);
        }
        return pst;
    }

    /**
     * Método responsável por retornar um PreparedStatemento com a query
     * para realizar a exibição dos dados dos herois cadastrados no banco de dados 
     * @return PreparedStatemento com a query para exibir os dados dos herois
     */
    @Override
    public PreparedStatement statementMostrar() {
        JFrame tela = new JFrame();
         
        tela.setTitle("Herois cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Identidade","Idade","Altura","Inimigo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        
        String query = "SELECT * FROM HEROI";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = con.prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                String nome = rst.getString("nome_heroi");
                String identidade = rst.getString("identidade_heroi");
                String idade = rst.getString("idade_heroi");
                String altura = rst.getString("altura_heroi");
                String inimigo = rst.getString("inimigo_heroi");
                modelo.addRow(new Object[] { nome,identidade,idade,altura,inimigo});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Exibe a janela
        tela.setVisible(true);
        return pst;
    }
}
