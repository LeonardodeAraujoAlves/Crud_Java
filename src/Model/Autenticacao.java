/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author L.A.A
 */
public class Autenticacao {
    ConnectionSingleton inst = ConnectionSingleton.getInstancy();
    Connection con = inst.getConexao();

    public Autenticacao(String nome, String senha) {
    
    }
    
    
    public boolean Acessa(String nome ,String senha){
        
        
        try {
            String query = "SELECT * FROM USUARIO WHERE nome =? AND senha=?";
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, nome);
            pst.setString(2,senha);
            
             ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
