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

    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        nome = this.nome;
        senha = this.senha;
    }
    
    public Usuario(){}

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
        try{
            String query = "SELECT * FROM USUARIO";   
            
            PreparedStatement pst =  con.prepareStatement(query);
            
            ResultSet rst = pst.executeQuery();
            
            System.out.println("Resultado da pesquisa");
            
            while(rst.next()){
                
                System.out.println("Nome :" + rst.getString("nome"));
                System.out.println("Senha :" + rst.getString("senha"));
                System.out.println("#####################################################");
                /*
                JOptionPane.showMessageDialog(null, "Nome :" + rst.getString("nome_heroi") +"\n"+
                        "identidade :" + rst.getString("identidade_heroi")+"\n"+
                        "idade :" + rst.getString("idade_heroi")+"\n"+
                        "altura :" + rst.getString("altura_heroi")+"\n"+
                        "inimigo :" + rst.getString("inimigo_heroi")
                        );
*/
            }
        }catch(SQLException ex){
            System.out.println("Ocorreu um erro ao exibit os registros:" + ex);
        }
    }

    public void deletar(String Nome){
		try{
			String query = "DELETE FROM USUARIO WHERE NOME = ?";
			PreparedStatement pst = con.prepareStatement(query);			
			
			pst.setString(1, Nome);
			
			int resultado = pst.executeUpdate();
			
			if(resultado > 0){
				System.out.println("### Registro eliminado com sucesso. ###");
			}else{
				System.out.println("### Nenhum registro eliminado. ###");
			} 
		}catch(SQLException e){
			System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
		}
	}
}
