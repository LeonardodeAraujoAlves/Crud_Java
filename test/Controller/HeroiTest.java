/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author L.A.A
 */
public class HeroiTest {
    
    public HeroiTest() {
    }
    
    

    /**
     * Test of statementInserir method, of class Heroi.
     */
    @Test
    public void testStatementInserir() {
        /*
        System.out.println("statementInserir");
        Heroi instance = new Heroi();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementInserir();
        assertEquals(expResult, result);
        */
        // TODO review the generated test code and remove the default call to fail.
        
        //fail("The test case is a prototype.");
        Heroi instance = new Heroi();
        PreparedStatement pst = instance.statementInserir();
        try {
            pst.setString(1, "Homem-Aranha");
            pst.setString(2, "Peter Parker");
            pst.setInt(3, 25);
            pst.setDouble(4, 1.75);
            pst.setString(5, "Duende Verde");
        } catch (SQLException e) {
            fail("Não foi possível configurar o PreparedStatement.");
        }
        
        // Verificação do objeto PreparedStatement
        assertNotNull("O PreparedStatement não foi criado corretamente.", pst);
    }

    /**
     * Test of statementDeletar method, of class Heroi.
     */
    @Test
    public void testStatementDeletar() {
        System.out.println("statementDeletar");
        Heroi instance = new Heroi();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementDeletar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementAtualizar method, of class Heroi.
     */
    @Test
    public void testStatementAtualizar() {
        System.out.println("statementAtualizar");
        Heroi instance = new Heroi();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementAtualizar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementMostrar method, of class Heroi.
     */
    @Test
    public void testStatementMostrar() {
        System.out.println("statementMostrar");
        Heroi instance = new Heroi();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementMostrar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
