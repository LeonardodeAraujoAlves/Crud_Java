package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

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
        altura = this. altura;
        inimigo = this.inimigo;
    }

    public  void inserir(String nome_heroi, String identidade_heroi, int idade_heroi, double altura_heroi, String inimigo_heroi) {

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

    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
