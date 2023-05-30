/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author L.A.A
 */
public class InsertArquivo implements Runnable {

    ConnectionSingleton inst = ConnectionSingleton.getInstance();
    Connection con = inst.getConexao();
    private static final String ARQUIVO = "C:\\Users\\L.A.A\\Documents\\NetBeansProjects\\Cad_HeroisEViloes\\src\\insere.txt";

    @Override
    public void run() {
        Thread Monitor = new Thread(() -> {
            try {
                System.out.println("iniciada");
                BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
                String linha = null;
                while (true) {
                    linha = leitor.readLine();
                    if (linha != null) {
                        inserirNoBanco(linha);
                    }
                    Thread.sleep(20000); // aguarda 20 segundo antes de verificar novamente o arquivo
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao executar a thread " + e);
            }
        });
        Monitor.start();
    }

    private void inserirNoBanco(String valores) {
        try {

            String[] valoresSeparados = valores.split(",");

            if (valoresSeparados.length == 2) {
                System.out.println("Tamanho do array" + valoresSeparados.length);
                String queryUsuario = "INSERT INTO USUARIO VALUES (?, ?)";
                PreparedStatement pst = con.prepareStatement(queryUsuario);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);

                pst.executeUpdate();
                System.out.println("Valores inseridos no banco: " + valores);
            } else if (valoresSeparados.length == 5) {

                String query = "INSERT INTO HEROI VALUES (?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);
                pst.setInt(3, Integer.parseInt(valoresSeparados[2]));
                pst.setDouble(4, Double.parseDouble(valoresSeparados[3]));
                pst.setString(5, valoresSeparados[4]);

                pst.executeUpdate();

                System.out.println("Inerção realizada com sucesso");
                System.out.println("-" + valoresSeparados[0] + "-");

            } else if (valoresSeparados.length == 8) {
                String query = "INSERT INTO vilao VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, valoresSeparados[0]);
                pst.setString(2, valoresSeparados[1]);
                pst.setDouble(3, Double.parseDouble( valoresSeparados[2]));
                pst.setString(4, valoresSeparados[3]);
                pst.setString(5, valoresSeparados[4]);
                pst.setString(6, valoresSeparados[5]);
                pst.setInt(7, Integer.parseInt( valoresSeparados[6]));
                pst.setString(8, valoresSeparados[7]);

                int resultado = pst.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar inserir os dados :" + e);
        }
    }
}
