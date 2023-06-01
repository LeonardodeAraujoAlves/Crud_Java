package Model;

import Controller.ConnectionSingleton;
import Controller.InsertArquivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe responsável por realizar 
 * a autênticação do usuário atravéz
 * da consulta no banco de dados
 *
 * @author L.A.A
 */
public class Autenticacao {

    ConnectionSingleton inst = ConnectionSingleton.getInstance();
    Connection con = inst.getConexao();

    public Autenticacao(String nome, String senha) {

    }
    
    /**
     * Função responsável por verificar a existência dos dados inseridos
     * pelo usuário dentro da base de dados e efetuar o login 
     * 
     * @param nome nome que foi capturado no campo da interface gráfica
     * @param senha senha que foi capturado no campo da interface gráfica
     * @return true caso os dados dos paramentro existirem na base de dados 
     * @return  false caso os dados não existam na base de dados
     */

    public boolean Acessa(String nome, String senha) {

        try {
            String query = "SELECT * FROM USUARIO WHERE nome_usuario =? AND senha_usuario=?";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                InsertArquivo arq = new InsertArquivo();
                Thread baguioDoido = new Thread(arq);
                baguioDoido.start();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao realizar a consulta :" + ex);
        }
        return false;
    }
}
