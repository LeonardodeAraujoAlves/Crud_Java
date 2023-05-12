package Controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author L.A.A
 */
public class Connection {
           private static String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
           private static String usuario = "root";
           private static String senha   = " ";
           
public static void insereHeroi(String nome_heroi, String identidade_heroi, int idade_heroi,double altura_heroi, String inimigo_heroi){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            java.sql.Connection conexao = DriverManager.getConnection(urlJDBC,usuario,senha);
        
                if(conexao != null){
                    System.out.println("Banco acessado com sucesso");
                    String cmd = "INSERT INTO HEROI (nome_heroi, identidade_heroi, idade_heroi,altura_heroi, inimigo_heroi) VALUES" 
                        + "('"+nome_heroi+"','"+identidade_heroi+"',"+idade_heroi+","+altura_heroi+",'"+inimigo_heroi+"')";
                    System.out.println(cmd);
                    Statement inserir = (Statement) conexao.createStatement();
                    inserir.execute(cmd);
                    conexao.close();
                }else{
                    System.out.println("Não foi possivel acessar o banco de dados");
                }
                
        }catch(SQLException exsql){
            System.out.println("Ocorreu um erro ao acessar o banco de dados :" + exsql);
        }catch(ClassNotFoundException exClasse){
            System.err.println("Ocorreu um erro ao tentar carregar a clasee :" + exClasse);
        }
          
}
    
public static void insereVilao(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao,String lugar_principal,String arma,int quant_vitimas,String mascote_vilao){
        
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
}