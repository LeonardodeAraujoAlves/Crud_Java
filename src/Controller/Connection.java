package Controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author L.A.A
 */
public class Connection  {
           private static String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
           private static String usuario = "root";
           private static String senha   = "751204Laa.15";
           
           
           


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

public static void mostraVilao(){
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           
           java.sql.Connection conexao = (java.sql.Connection) DriverManager.getConnection(urlJDBC,usuario,senha);

               if(conexao != null){
                   System.out.println("Banco acessado com sucesso");
                   String cmd ="SELECT * VILAO"; 
                   System.out.println(cmd);
                   Statement mostrar = (Statement) conexao.createStatement();
                   mostrar.execute(cmd);
                   System.out.println(mostrar);
                   
                   ResultSet resultado = mostrar.executeQuery(cmd) ;
                   
                   while(resultado.next()){
                       System.out.println( resultado.getString("VILAO"));
                       JOptionPane.showMessageDialog(null, resultado.getString("NOME_VILAO"));
                       
                   }
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
