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
 *
 * @author L.A.A
 */
public class Usuario extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstance();
    Connection con = inst.getConexao();

    private String nome;
    private String senha;
    private String NomeAtual;

    public Usuario(String nomeUsr, String senhaUsr) {
        nome = nomeUsr;
        senha = senhaUsr;
        NomeAtual = nomeUsr;
    }
    
    public Usuario(String nomeUsr){
        nome = nomeUsr;
    }
    
    public Usuario() {
    }
    
    @Override
    public PreparedStatement statementInserir() {
            String query = "INSERT INTO USUARIO VALUES (?,?)";
            PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome);
            pst.setString(2, senha);
         } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
        return pst;
    }

    @Override
    public PreparedStatement statementDeletar() {
            String query = "DELETE FROM USUARIO WHERE nome_usuario = ?";
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
            String query = "UPDATE USUARIO SET nome_usuario = ?, senha_usuario = ? WHERE nome_usuario = ?";
            PreparedStatement pst  = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setString(3, NomeAtual);
        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }
        return pst;
    }

    @Override
    public PreparedStatement statementMostrar() {
        JFrame tela = new JFrame();

        tela.setTitle("Usuarios cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Senha"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        
        String query = "SELECT * FROM USUARIO";
        PreparedStatement pst = null;
        ResultSet rst = null;
        
        try {
            pst = con.prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                String nome = rst.getString("nome_usuario");
                String senha = rst.getString("senha_usuario");
                modelo.addRow(new Object[]{nome, senha});
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
