package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author L.A.A
 */
public class Usuario extends BDObject{
    
    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();
    
    private String nome; 
    private String senha;
    
    public Usuario(String nome , String senha){
        nome = this.nome;
        senha = this.senha;
    }
    
    public void inserir(String nome , String senha) {
         try {
            String query = "INSERT INTO USUARIO VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);
           
            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }
}


