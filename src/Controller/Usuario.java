package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
        try {
            String query = "SELECT * FROM USUARIO";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {

                System.out.println("Nome :" + rst.getString("nome"));
                System.out.println("Senha :" + rst.getString("senha"));
                System.out.println("#####################################################");
                
                JOptionPane.showMessageDialog(null, 
                        "Nome :" + rst.getString("nome")+"\n"+
                        "Senha :" + rst.getString("senha")+"\n"
                        );
                 
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
    }

    public void atualizar() {
        try {

            String query = "UPDATE USUARIO SET nome = ?, senha= ? WHERE nome = ?" ;
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2, senha);
            pst.setString(3, NomeAtual);
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

    public void deletar(String Nome) {
        try {
            String query = "DELETE FROM USUARIO WHERE NOME = ?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, Nome);

            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null,"### Registro eliminado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null,"### Nenhum registro eliminado. ###");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
    }
}
