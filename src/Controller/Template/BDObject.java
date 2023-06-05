package Controller.Template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta classe se trata de um template method
 * que deverá ser implementado nas classes que
 * realizam operações de persistência no banco de dados
 *
 * @author L.A.A
 */
public abstract class BDObject {

    public BDObject() {
    }
    
    
    /**
     * Método que insere um registro no banco de dados,
     * é necessário implementar o método statementInserir na classe que herda BDObject.
     */
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
   
   /**
     * Método que remove um registro no banco de dados,
     * é necessário implementar o método statementDeletar na classe que herda BDObject.
     */
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
   
   /**
     * Método que atualiza um registro no banco de dados,
     * é necessário implementar o método statementatualizar na classe que herda BDObject.
     */
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
   
   /**
     * Método que mostra os registros do  banco de dados,
     * é necessário implementar o método statementMostrar na classe que herda BDObject.
     */
   
   public void mostrar(){
       JFrame tela = new JFrame();
       try {
            PreparedStatement pst = statementMostrar();
            ResultSet rst = pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("Ocorreu um erro ao realizar a consulta na base de dados :" + e);
       }
       
   };

   public abstract PreparedStatement statementInserir();
   public abstract PreparedStatement statementDeletar();
   public abstract PreparedStatement statementAtualizar();
   public abstract PreparedStatement statementMostrar();
   
}

