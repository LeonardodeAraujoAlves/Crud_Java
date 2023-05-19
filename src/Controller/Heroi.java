/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Template.BDObject;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author L.A.A
 */
public class Heroi extends BDObject {

    /* 
    String nome,identidade,inimigo;
     int idade;
     double altura;
     */
    private static String urlJDBC = "jdbc:mysql://localhost:3306/heroiseviloes";
    private static String usuario = "root";
    private static String senha = "751204Laa.15";

    public Heroi(String nome, String identidade, int idade, double altura, String inimigo) {

    }

    public void inserir(String nome_heroi, String identidade_heroi, int idade_heroi, double altura_heroi, String inimigo_heroi) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection conexao = DriverManager.getConnection(urlJDBC, usuario, senha);

            if (conexao != null) {
                System.out.println("Banco acessado com sucesso");
                String cmd = "INSERT INTO HEROI (nome_heroi, identidade_heroi, idade_heroi,altura_heroi, inimigo_heroi) VALUES"
                        + "('" + nome_heroi + "','" + identidade_heroi + "'," + idade_heroi + "," + altura_heroi + ",'" + inimigo_heroi + "')";
                System.out.println(cmd);
                Statement inserir = (Statement) conexao.createStatement();
                inserir.execute(cmd);
                conexao.close();
            } else {
                System.out.println("Não foi possivel acessar o banco de dados");
            }

        } catch (SQLException exsql) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados :" + exsql);
        } catch (ClassNotFoundException exClasse) {
            System.err.println("Ocorreu um erro ao tentar carregar a clasee :" + exClasse);
        }

    }

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

}
