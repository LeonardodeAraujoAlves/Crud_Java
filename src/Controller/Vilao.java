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

    public Vilao() {

    }

    ;
    

    @Override
    public synchronized void inserir() {
        try {
            String query = "INSERT INTO vilao VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome_vilao);
            pst.setString(2, organizacao_vilao);
            pst.setDouble(3, altura_vilao);
            pst.setString(4, inimigo_vilao);
            pst.setString(5, lugar_principal);
            pst.setString(6, arma);
            pst.setInt(7, quant_vitimas);
            pst.setString(8, mascote_vilao);

            int resultado = pst.executeUpdate();

              System.out.println("-"  + nome_vilao + "-");
            if (resultado > 0) {
                System.out.println(resultado);
               
                JOptionPane.showMessageDialog(null, "### Registro inserido com sucesso. ###");
            } else {
                System.out.println(resultado);
                JOptionPane.showMessageDialog(null, "### Nenhum registro foi inserido. ###");
            }
           
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public synchronized void atualizar() {
        try {
            String query = "UPDATE VILAO SET  organizacao_vilao= ?,altura_vilao = ?, inimigo_vilao = ?,lugar_principal = ?, arma = ?, quant_vitimas = ?, mascote_vilao = ? WHERE nome_vilao = ?";
            PreparedStatement pst = con.prepareStatement(query);

            
            pst.setString(1, organizacao_vilao);
            pst.setDouble(2, altura_vilao);
            pst.setString(3, inimigo_vilao);
            pst.setString(4, lugar_principal);
            pst.setString(5, arma);
            pst.setInt(6, quant_vitimas);
            pst.setString(7, mascote_vilao);
            pst.setString(8, nome_vilao);
            
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro alterado. ###");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao atualizar banco de dados :" + ex);
        }
    }

    @Override
    public synchronized void mostrar() {
        
        JFrame tela = new JFrame();
        tela.setTitle("Vilões cadastrados");
        tela.setSize(800, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Organização","Altura","Inimigo","Lugar Principal","Arma","Quant_Vitimas","Mascote"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        
        try {
            String query = "SELECT * FROM VILAO";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                
                        String nome = rst.getString("nome_vilao");
                        String organização = rst.getString("organizacao_vilao");
                        String altura = rst.getString("altura_vilao");
                        String inimigo = rst.getString("inimigo_vilao");
                        String principal = rst.getString("lugar_principal");
                        String arma = rst.getString("arma") ;
                        String vitimas = rst.getString("quant_vitimas");
                        String mascote = rst.getString("mascote_vilao");
                        modelo.addRow(new Object[] { nome,organização,altura,inimigo,principal,arma,vitimas,mascote});
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
        tela.add(new JScrollPane(tabela));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Exibe a janela
        tela.setVisible(true);
    }

    public void deletar(String nome) {
        try {//ta funcionando não 
            String query = "DELETE FROM VILAO WHERE nome_vilao = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                System.out.println("### Registro eliminado com sucesso. ###");
            } else {
                System.out.println("### Nenhum registro eliminado. ###");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
    }

    @Override
    public void deletarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
