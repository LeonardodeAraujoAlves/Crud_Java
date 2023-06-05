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
 * Esta classe é responsável por representar um vilão dentro do sistema de cadastro
 * Ela estende a classe BDObject para permitir a persistência em banco de dados
 * Possui métodos para inserir, atualizar, deletar e mostrar informações de um herói no banco de dados
 * @author L.A.A
 * @version 1.6
 */
public class Vilao extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstance();
    Connection con = inst.getConexao();

    private String nome_vilao;
    private String organizacao_vilao;
    double altura_vilao;
    private String inimigo_vilao;
    private String lugar_principal;
    private String arma;
    private int quant_vitimas;
    private String mascote_vilao;

    public Vilao(String nome, String organizacao, double altura, String inimigo, String lugaPrincipal, String armaV, int vitimas, String mascote) {
        nome_vilao = nome;
        organizacao_vilao = organizacao;
        altura_vilao = altura;
        inimigo_vilao = inimigo;
        lugar_principal = lugaPrincipal;
        arma = armaV;
        quant_vitimas = vitimas;
        mascote_vilao = mascote;
    }

    public Vilao(String nome) {
        nome_vilao = nome;
    }

    public Vilao() {

    };

    /**
     * Método responsável por retornar um PreparedStatement com a query 
     * de inserção dos dados de um vilão no banco de dados
     * @return  PreparedStatement com a query de inserção
     */
    @Override
    public PreparedStatement statementInserir() {
        String query = "INSERT INTO vilao VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome_vilao);
            pst.setString(2, organizacao_vilao);
            pst.setDouble(3, altura_vilao);
            pst.setString(4, inimigo_vilao);
            pst.setString(5, lugar_principal);
            pst.setString(6, arma);
            pst.setInt(7, quant_vitimas);
            pst.setString(8, mascote_vilao);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
        return pst;
    }

    /**
    * Método responsável por retornar um PrearedStatement com a query
    * de remoção dos dados de um vilão no banco de dados
    * @return  PreparedStatement com a query de remoção
    */
    @Override
    public PreparedStatement statementDeletar() {
        String query = "DELETE FROM VILAO WHERE nome_vilao = ?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome_vilao);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
        return pst;
    }
    
    /**
     * Método responsável por retornar um PreparedStatement com a query
     * de atualização dos dados de um vilão no banco de dados
     * @return PreparedStatement com a query de atualização dos dados
     */

    @Override
    public PreparedStatement statementAtualizar() {

        String query = "UPDATE VILAO SET  organizacao_vilao= ?,altura_vilao = ?, inimigo_vilao = ?,lugar_principal = ?, arma = ?, quant_vitimas = ?, mascote_vilao = ? WHERE nome_vilao = ?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);

            pst.setString(1, organizacao_vilao);
            pst.setDouble(2, altura_vilao);
            pst.setString(3, inimigo_vilao);
            pst.setString(4, lugar_principal);
            pst.setString(5, arma);
            pst.setInt(6, quant_vitimas);
            pst.setString(7, mascote_vilao);
            pst.setString(8, nome_vilao);

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao atualizar banco de dados :" + ex);
        }
        return pst;
    }

    /**
     * Método responsável por retornar um PreparedStatemento com a query
     * para realizar a exibição dos dados dos vilões cadastrados no banco de dados 
     * @return PreparedStatemento com a query para exibir os dados dos vilões
     */
    @Override
    public PreparedStatement statementMostrar() {
        JFrame tela = new JFrame();
        tela.setTitle("Vilões cadastrados");
        tela.setSize(800, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Organização", "Altura", "Inimigo", "Lugar Principal", "Arma", "Quant_Vitimas", "Mascote"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        String query = "SELECT * FROM VILAO";
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = con.prepareStatement(query);
            rst = pst.executeQuery();

            while (rst.next()) {

                String nome = rst.getString("nome_vilao");
                String organização = rst.getString("organizacao_vilao");
                String altura = rst.getString("altura_vilao");
                String inimigo = rst.getString("inimigo_vilao");
                String principal = rst.getString("lugar_principal");
                String arma = rst.getString("arma");
                String vitimas = rst.getString("quant_vitimas");
                String mascote = rst.getString("mascote_vilao");
                modelo.addRow(new Object[]{nome, organização, altura, inimigo, principal, arma, vitimas, mascote});
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
