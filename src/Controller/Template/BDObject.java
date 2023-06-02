/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Esta classe se trata de um template method
 * que deverá ser implementado nas classes que
 * realizam operações no banco de dados
 *
 * @author L.A.A
 */
public abstract class BDObject {

    public BDObject() {
    }
    
    
    
   public void inserir(){
        try {            
            PreparedStatement pst = statementInserir();
            int resultado = pst.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro inserido com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro foi inserido. ###");
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir no banco de dados :" + ex);
        }
   }
   public void deletar(){
        try {
            PreparedStatement pst = statementDeletar();
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro eliminado.");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar deletar o registro :" + e);
        }
   };
   
   public  void atualizar(){
       try {
            PreparedStatement pst = statementAtualizar();
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "### Registro alterado com sucesso. ###");
            } else {
                JOptionPane.showMessageDialog(null, "### Nenhum registro alterado. ###");
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao atualizar banco de dados :" + ex);
        }
   };
   
   public abstract void mostrar();

   public abstract PreparedStatement statementInserir();
   public abstract PreparedStatement statementDeletar();
   public abstract PreparedStatement statementAtualizar();
}

