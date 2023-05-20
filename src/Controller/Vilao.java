package Controller;

import Controller.Template.BDObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author L.A.A
 */
public class Vilao extends BDObject {

    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    public Vilao(String nome, String organizacao, double altura, String inimigo, String lugaPrincipal, String arma, int quant_vitimas, String mascote) {

    }

    public synchronized void  inserir(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao, String lugar_principal, String arma, int quant_vitimas, String mascote_vilao) {
        try {
            String query = "INSERT INTO VILAO VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, nome_vilao);
            pst.setString(2, organizacao_vilao);
            pst.setDouble(3, altura_vilao);
            pst.setString(4, inimigo_vilao);
            pst.setString(5, lugar_principal);
            pst.setString(6, arma);
            pst.setInt(7, quant_vitimas);
            pst.setString(8, mascote_vilao);

            pst.executeUpdate();

            System.out.println("Inerção realizada com sucesso");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
    }

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
        /*
        try {
            Class.forName("com.mysql.jdbc.Driver");

            java.sql.Connection conexao = (java.sql.Connection) DriverManager.getConnection(urlJDBC, usuario, senha);

            if (conexao != null) {
                System.out.println("Banco acessado com sucesso");
                String cmd = "SELECT * VILAO";
                System.out.println(cmd);
                Statement mostrar = (Statement) conexao.createStatement();
                mostrar.execute(cmd);
                System.out.println(mostrar);

                ResultSet resultado = mostrar.executeQuery(cmd);

                while (resultado.next()) {
                    System.out.println(resultado.getString("VILAO"));
                    JOptionPane.showMessageDialog(null, resultado.getString("NOME_VILAO"));

                }
                conexao.close();
            } else {
                System.out.println("Ocorreu um erro ao conectar a base de dados");
            }

        } catch (SQLException exsql) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados :" + exsql);
        } catch (ClassNotFoundException exClasse) {
            System.err.println("Ocorreu um erro ao tentar carregar a clasee :" + exClasse);

}
         */
    }

}
