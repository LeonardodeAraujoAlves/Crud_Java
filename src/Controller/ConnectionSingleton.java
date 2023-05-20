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

    private static String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private static String usuario = "root";
    private static String senha = "haha";

    private static ConnectionSingleton instance;

    private ConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("O driver se encontra ");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão functionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão" + ex.getMessage());
        }
    }

    public static synchronized ConnectionSingleton getInstancy() {

        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    public synchronized Connection getConexao() {
        return this.conexao;
    }
}
