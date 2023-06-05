package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author L.A.A
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    /**
     * Test of statementInserir method, of class Usuario.
     */
    @Test
    public void testStatementInserir() {
        System.out.println("statementInserir");
        Usuario instance = new Usuario();
        PreparedStatement expResult = instance.statementInserir();
            try{
            expResult.setString(1, "root");
            expResult.setString(2, "1234");
           
            }catch(SQLException ex){
                fail("Ocorreu um erro ao executar a ação");
            }
        assertNotNull("O PreparedStatement não foi criado corretamente.", expResult);
    }

    /**
     * Test of statementDeletar method, of class Usuario.
     */
    @Test
    public void testStatementDeletar() {
        
        System.out.println("statementDeletar");
        Usuario instance = new Usuario();

        PreparedStatement expResult = instance.statementDeletar();
        try {
            expResult.setString(1, "root");
        } catch (SQLException ex) {
            fail("Ocorreu um erro ao executar a operação :" + ex);
        }
        assertNotNull("O remoção não ocorreu adequadamente :", expResult);
    }

    /**
     * Test of statementAtualizar method, of class Usuario.
     */
    @Test
    public void testStatementAtualizar() {
        System.out.println("statementAtualizar");
        Usuario instance = new Usuario();
        Usuario instance2 = new Usuario("root", "1234");
        PreparedStatement expResult = instance.statementAtualizar();
         try {
            expResult.setString(1, "root");
            expResult.setString(2, "4321");
            expResult.setString(3, "root");
         } catch (Exception e) {
            fail("Não foi possivel executar a operação");
         }
        PreparedStatement result = instance2.statementAtualizar();
        assertNotEquals("Os objetos não corresponde ", expResult, result);
    }

    /**
     * Test of statementMostrar method, of class Usuario.
     */
    @Test
    public void testStatementMostrar() {
        System.out.println("statementMostrar");
        Usuario instance = new Usuario();
        PreparedStatement expResult = instance.statementMostrar();
        PreparedStatement result = instance.statementMostrar();
        assertNotSame(expResult, result);
    }
}
