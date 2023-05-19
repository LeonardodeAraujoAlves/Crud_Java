package Controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L.A.A
 */
public class Connection {

    private Connection conexao;
    private String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private String usuario = "root";
    private String senha = "751204Laa.15";

    private static Connection instacy;

    private Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("O driver se encontra ");
            this.conexao = (Connection) DriverManager.getConnection(urlJDBC, usuario, usuario);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão");
        }
        
      

    }   

    public static Connection getInstancy() {

        if (instacy == null) {
            instacy = new Connection();
        }
        return instacy;
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
}

