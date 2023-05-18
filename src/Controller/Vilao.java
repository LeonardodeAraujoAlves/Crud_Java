package Controller;

import Controller.Template.BDObject;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author L.A.A
 */
public class Vilao extends BDObject {

    @Override
    public void inserir(String nome_heroi, String identidade_heroi, int idade_heroi, double altura_heroi, String inimigo_heroi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    @Override
    public void inserir(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao, String lugar_principal, String arma, int quant_vitimas, String mascote_vilao) {
        try{
           Class.forName("com.mysql.jdbc.Driver");
           
           java.sql.Connection conexao = (java.sql.Connection) DriverManager.getConnection(urlJDBC,usuario,senha);

               if(conexao != null){
                   System.out.println("Banco acessado com sucesso");
                   String cmd = "INSERT INTO VILAO (nome_vilao, organizacao_vilao, altura_vilao,inimigo_vilao, lugar_principal,arma,quant_vitimas,mascote_vilao) VALUES" 
                       + "('"+nome_vilao+"','"+organizacao_vilao+"','"+altura_vilao+"','"+inimigo_vilao+"','"+lugar_principal+"','"+arma+"','"+quant_vitimas+"','"+mascote_vilao+"')";
                   System.out.println(cmd);
                   Statement inserir = (Statement) conexao.createStatement();
                   inserir.execute(cmd);
                   conexao.close();
               }else{
                   System.out.println("Ocorreu um erro ao conectar a base de dados");
               }

        }catch(SQLException exsql){
               System.out.println("Ocorreu um erro ao acessar o banco de dados :" + exsql);
        }catch(ClassNotFoundException exClasse){
               System.err.println("Ocorreu um erro ao tentar carregar a clasee :" + exClasse);
        }
    }
    
*/
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao, String lugar_principal, String arma, int quant_vitimas, String mascote_vilao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
