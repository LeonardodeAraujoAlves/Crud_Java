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
public class Heroi extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    private String nome;
    private String identidade;
    private int idade;
    private double altura;
    private String inimigo;

    public Heroi(String nome, String identidade, int idade, double altura, String inimigo) {
        nome = this.nome;
        identidade = this.identidade;
        idade = this.idade;
        altura = this.altura;
        inimigo = this.inimigo;
    }

    public Heroi() {
    }

    public void inserir(String nome_heroi, String identidade_heroi, int idade_heroi, double altura_heroi, String inimigo_heroi) {

        try {
            String query = "INSERT INTO HEROI VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome_heroi);
            pst.setString(2, identidade_heroi);
            pst.setInt(3, idade_heroi);
            pst.setDouble(4, altura_heroi);
            pst.setString(5, inimigo_heroi);

            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
        try {
            String query = "SELECT * FROM HEROI";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rst = pst.executeQuery();

            System.out.println("Resultado da pesquisa");

            while (rst.next()) {
                System.out.println("#####################################################");
                System.out.println("Nome :" + rst.getString("nome_heroi"));
                System.out.println("identidade :" + rst.getString("identidade_heroi"));
                System.out.println("idade :" + rst.getString("idade_heroi"));
                System.out.println("altura :" + rst.getString("inimigo_heroi"));
                System.out.println("inimigo :" + rst.getString("nome_heroi"));
                System.out.println("#####################################################");

                JOptionPane.showMessageDialog(null, "Nome :" + rst.getString("nome_heroi") + "\n"
                        + "identidade :" + rst.getString("identidade_heroi") + "\n"
                        + "idade :" + rst.getString("idade_heroi") + "\n"
                        + "altura :" + rst.getString("altura_heroi") + "\n"
                        + "inimigo :" + rst.getString("inimigo_heroi")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
    }

}
