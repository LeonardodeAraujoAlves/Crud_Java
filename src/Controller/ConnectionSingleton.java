package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author L.A.A
 */

public class ConnectionSingleton {

    private Connection conexao;

    private static final String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private static final String usuario = "root";
    private static final String senha = "751204Laa.15";
    
    

    private static ConnectionSingleton instance;

    private ConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão" + ex.getMessage());
        }
    }

    public static synchronized ConnectionSingleton getInstance() {

        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    public synchronized Connection getConexao() {
        return this.conexao;
    }
}
