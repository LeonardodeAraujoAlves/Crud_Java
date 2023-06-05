package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo de Araujo Alves
 */
public class HeroiTest {

    public HeroiTest() {
    }

    /**
     * Test of statementInserir method, of class Heroi.
     */
    @Test
    public void testStatementInserir() {
        Heroi instance = new Heroi();
        PreparedStatement pst = instance.statementInserir();
        try {
            pst.setString(1, "Homem-Aranha");
            pst.setString(2, "Peter Parker");
            pst.setInt(3, 25);
            pst.setDouble(4, 1.75);
            pst.setString(5, "Duende Verde");
        } catch (SQLException e) {
            fail("Ocorreu um erro ao tentar realizar a onperação :" + e);
        }
        assertNotNull("O PreparedStatement não foi criado corretamente.", pst);
    }

    /**
     * Test of statementDeletar method, of class Heroi.
     */
    @Test
    public void testStatementDeletar() {
        System.out.println("statementDeletar");
        Heroi instance = new Heroi();

        PreparedStatement pst = instance.statementDeletar();
        try {
            pst.setString(1, "Homem-Aranha");
        } catch (SQLException ex) {
            fail("Ocorreu um erro ao executar a operação :" + ex);
        }
        assertNotNull("O remoção não ocorreu adequadamente :", pst);
    }

    /**
     * Test of statementAtualizar method, of class Heroi.
     */
     @Test
    
    public void testStatementAtualizar() {
        System.out.println("statementAtualizar");
        Heroi instance = new Heroi();
        Heroi instance2 = new Heroi("Porco-Aranha", "Peter Parker", 12, 0.65, "Patas");
        PreparedStatement expResult = instance.statementAtualizar();
         try {
            expResult.setString(1, "Porco-Aranha");
            expResult.setString(2, "Peter Parker");
            expResult.setInt(3, 12);
            expResult.setDouble(4, 0.65);
            expResult.setString(5, "Patas");
         } catch (Exception e) {
            fail("Não foi possivel executar a operação");
         }
        PreparedStatement result = instance2.statementAtualizar();
        assertNotEquals("Os objetos não corresponde ", expResult, result);
   }
    /**
     * Test of statementMostrar method, of class Heroi.
     */
    @Test
    public void testStatementMostrar() {
        System.out.println("statementMostrar");
        Heroi instance = new Heroi();
        PreparedStatement expResult = instance.statementMostrar();
        PreparedStatement result = instance.statementMostrar();
        assertNotSame(expResult, result);
    }
}
