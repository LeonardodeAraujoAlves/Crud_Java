package Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author L.A.A
 */


public class ConnectionManeira {

    private  Connection conexao;
    
    private static String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private static String usuario = "root";
    private static String senha = "751204Laa.15";

    private static ConnectionManeira instacy;

    private ConnectionManeira() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("O driver se encontra ");
            conexao =  DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão" + ex.getMessage());
        }
        
      

    }   

    public static synchronized ConnectionManeira getInstancy() {

        if (instacy == null) {
            instacy = new ConnectionManeira();
        }
        return instacy;
    }
    
    public  synchronized Connection getConexao(){
        return  this.conexao;
    }
}
