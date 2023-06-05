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
 *Esta classe é responsável por representar um usuário do sistema dentro do sistema de cadastro,
 *ela estende a classe BDObject para permitir a persistência em banco de dados
 *Possui métodos para inserir, atualizar, deletar e mostrar informações de um usuário no banco de dados
 * @author Leonardo de Araujo Alves
 *  @version 1.6 
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
    
    /**
     * Método responsável por retornar um PreparedStatement com a query 
     * de inserção dos dados de um usuário no banco de dados
     * @return  PreparedStatement com a query de inserção
     */
    
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

    /**
    * Método responsável por retornar um PrearedStatement com a query
    * de remoção dos dados de um usuário no banco de dados
    * @return  PreparedStatement com a query de remoção
    */
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

    /**
     * Método responsável por retornar um PreparedStatement com a query
     * de atualização dos dados de um usuário no banco de dados
     * @return PreparedStatement com a query de atualização dos dados
     */
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
    
    /**
     * Método responsável por retornar um PreparedStatemento com a query
     * para realizar a exibição dos dados dos usuários cadastrados no banco de dados 
     * @return PreparedStatemento com a query para exibir os dados dos usuários
     */

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
