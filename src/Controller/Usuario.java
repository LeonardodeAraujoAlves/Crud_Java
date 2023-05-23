package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author L.A.A
 */
public class Usuario extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        nome = this.nome;
        senha = this.senha;
    }

    public void inserir(String nome, String senha) {
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
            
            ResultSet rst = pst.executeQuery(query);
            
            ArrayList<String> usuarios = new ArrayList<String>();
            
                while(rst.next()){
                 //   usuarios.add(rst.)
                }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao listar os usuarios: " + ex);
        }
        
    }
    
    
}
