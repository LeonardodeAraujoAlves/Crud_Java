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

    public Heroi() {
    }

    public void inserir() {

        try {
            String query = "INSERT INTO HEROI VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, identidade);
            pst.setInt(3, idade);
            pst.setDouble(4, altura);
            pst.setString(5, inimigo);

            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");
            System.out.println("-"  + nome + "-");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void atualizar() {
        try {

            String query = "UPDATE HEROI SET nome_heroi = ?, idade_heroi= ?, altura_heroi = ?, inimigo_heroi= ? WHERE identidade_heroi = ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.setDouble(3, altura);
            pst.setString(4, inimigo);
            pst.setString(5, identidade);
            
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
               JOptionPane.showMessageDialog(null,"### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null,"### Nenhum registro alterado. ###");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
    }

    public void deletar(String nome) {
        try {
            String query = "DELETE FROM HEROI WHERE NOME_HEROI = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro eliminado.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
    }

    @Override
    public void mostrar() {
        
        JFrame tela = new JFrame();
         
        tela.setTitle("Herois cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Identidade","Idade","Altura","Inimigo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        try {
            String query = "SELECT * FROM HEROI";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

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
    }

    @Override
    public void deletarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
