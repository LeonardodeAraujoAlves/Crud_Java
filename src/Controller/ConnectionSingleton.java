package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe se trata de uma implementação 
 * do padrão de projeto singleton para efetuar
 * conexão e acesso ao banco de dados mysql
 *
 *
 * @author Leonardo de Araujo Alves
 */

public class ConnectionSingleton {

    private Connection conexao;

    private static final String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private static final String usuario = "root";
    private static final String senha = "751204Laa.15)";
    
    

    private static ConnectionSingleton instance;

    private ConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(urlJDBC, usuario, senha);
            System.out.println("Conexão funcionando");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi encontrado" + ex);
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao efetuar a conexão" + ex.getMessage());
        }
    }

    /**
     * Método estático que retorna a única instância da classe ConnectionSingleton.
     * Se a instância ainda não foi criada, o método cria a instância e a retorna.
     * 
     * @return A instância única da classe ConnectionSingleton.
     */
    public static synchronized ConnectionSingleton getInstance() {

        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    /**
     * Método que retorna a conexão com o banco de dados.
     * 
     * @return A conexão com o banco de dados.
     */
    public synchronized Connection getConexao() {
        return this.conexao;
    }
}
