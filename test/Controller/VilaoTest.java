package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author L.A.A
 */
public class VilaoTest {
    
    public VilaoTest() {
    }
    
    /**
     * Test of statementInserir method, of class Vilao.
     */
    @Test
    public void testStatementInserir() {
        System.out.println("statementInserir");
        Vilao instance = new Vilao();
        PreparedStatement expResult = instance.statementInserir();
            try{
            expResult.setString(1, "KelThuzad");
            expResult.setString(2, "Flagelo");
            expResult.setDouble(3, 1.98);
            expResult.setString(4, "Arthas");
            expResult.setString(5, "Stratholme");
            expResult.setString(6, "Magia");
            expResult.setInt(7, 800);
            expResult.setString(8, "Mr.Biggleswoth");
            }catch(SQLException ex){
                fail("Ocorreu um erro ao executar a ação");
            }
        assertNotNull("O PreparedStatement não foi criado corretamente.", expResult);
    }

    /**
     * Test of statementDeletar method, of class Vilao.
     */
    @Test
    public void testStatementDeletar() {
        
        System.out.println("statementDeletar");
        Heroi instance = new Heroi();

        PreparedStatement expResult = instance.statementDeletar();
        try {
            expResult.setString(1, "KelThuzad");
        } catch (SQLException ex) {
            fail("Ocorreu um erro ao executar a operação :" + ex);
        }
        assertNotNull("O remoção não ocorreu adequadamente :", expResult);
    }

    /**
     * Test of statementAtualizar method, of class Vilao.
     */
    @Test
    public void testStatementAtualizar() {
        
         System.out.println("statementAtualizar");
        Vilao instance = new Vilao();
        Vilao instance2 = new Vilao("KelThuzad", "Flagelo", 2.89, "MalGanis","Stratholme","magia", 1000, "Mr.Biggleswoth");
        PreparedStatement expResult = instance.statementAtualizar();
         try {
            
            expResult.setString(1, "Flagelo");
            expResult.setDouble(2, 2.98);
            expResult.setString(3, "MalGanis");
            expResult.setString(4, "Stratholme");
            expResult.setString(5, "magia");
            expResult.setInt(6, 1000);
            expResult.setString(7, "Mr.Biggleswoth");
            expResult.setString(8, "KelThuzad");
         } catch (Exception e) {
            fail("Não foi possivel executar a operação");
         }
        PreparedStatement result = instance2.statementAtualizar();
        assertNotEquals("Os objetos não corresponde ", expResult, result);
    }

    /**
     * Test of statementMostrar method, of class Vilao.
     */
    @Test
    public void testStatementMostrar() {
        System.out.println("statementMostrar");
        Vilao instance = new Vilao();
        PreparedStatement expResult = instance.statementMostrar();
        PreparedStatement result = instance.statementMostrar();
        assertNotSame(expResult, result);
    }
}
