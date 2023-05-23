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
public class Vilao extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    public Vilao(String nome, String organizacao, double altura, String inimigo, String lugaPrincipal, String arma, int quant_vitimas, String mascote) {

    }
    
    public Vilao(){
    
    };
    

    public synchronized void  inserir(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao, String lugar_principal, String arma, int quant_vitimas, String mascote_vilao) {
        try {
            String query = "INSERT INTO VILAO VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome_vilao);
            pst.setString(2, organizacao_vilao);
            pst.setDouble(3, altura_vilao);
            pst.setString(4, inimigo_vilao);
            pst.setString(5, lugar_principal);
            pst.setString(6, arma);
            pst.setInt(7, quant_vitimas);
            pst.setString(8, mascote_vilao);

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
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public void mostrar() {
        try{
            String query = "SELECT * FROM VILAO";   
            
            PreparedStatement pst =  con.prepareStatement(query);
            
            ResultSet rst = pst.executeQuery();
            
            System.out.println("Resultado da pesquisa");
            
            while(rst.next()){
                
                System.out.println("Nome :" + rst.getString("nome_vilao"));
                System.out.println("Organização :" + rst.getString("organizacao_vilao"));
                System.out.println("altura :" + rst.getString("altura_vilao"));
                System.out.println("inimigo :" + rst.getString("inimigo_vilao"));
                System.out.println("Lugar principal :" + rst.getString("lugar_principal"));
                System.out.println("Arma :" + rst.getString("arma"));
                System.out.println("Quantidade de vitimas :" + rst.getString("quant_vitimas"));
                System.out.println("Mascote :" + rst.getString("mascote_vilao"));
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

}
