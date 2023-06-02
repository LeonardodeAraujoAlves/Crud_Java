package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author L.A.A
 * @version 1.4
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
