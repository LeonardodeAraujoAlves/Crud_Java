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

    public Usuario() {
    }

    @Override
    public void inserir() {
        try {
            String query = "INSERT INTO USUARIO VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro Realizado!");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void mostrar() {
        JFrame tela = new JFrame();

        tela.setTitle("Usuarios cadastrados");
        tela.setSize(500, 300);
        tela.setResizable(false);
        // Cria a tabela
        String[] colunas = {"Nome", "Senha"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);

        try {
            String query = "SELECT * FROM USUARIO";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

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
    }

    @Override
    public void atualizar() {
        try {

            String query = "UPDATE USUARIO SET nome_usuario = ?, senha_usuario = ? WHERE nome_usuario = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setString(3, NomeAtual);
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro alterado. ###");
            }

        } catch (SQLException e) {
            System.out.println("Erro:\n" + e);
        }

    }

    public void deletar(String Nome) {
        try {
            String query = "DELETE FROM USUARIO WHERE nome_usuario = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, Nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro eliminado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro eliminado. ###");
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
