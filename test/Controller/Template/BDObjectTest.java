/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Template;

import java.sql.PreparedStatement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author L.A.A
 */
public class BDObjectTest {
    
    public BDObjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class BDObject.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        BDObject instance = new BDObjectImpl();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class BDObject.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        BDObject instance = new BDObjectImpl();
        instance.deletar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class BDObject.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        BDObject instance = new BDObjectImpl();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class BDObject.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        BDObject instance = new BDObjectImpl();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementInserir method, of class BDObject.
     */
    @Test
    public void testStatementInserir() {
        System.out.println("statementInserir");
        BDObject instance = new BDObjectImpl();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementInserir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementDeletar method, of class BDObject.
     */
    @Test
    public void testStatementDeletar() {
        System.out.println("statementDeletar");
        BDObject instance = new BDObjectImpl();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementDeletar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementAtualizar method, of class BDObject.
     */
    @Test
    public void testStatementAtualizar() {
        System.out.println("statementAtualizar");
        BDObject instance = new BDObjectImpl();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementAtualizar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of statementMostrar method, of class BDObject.
     */
    @Test
    public void testStatementMostrar() {
        System.out.println("statementMostrar");
        BDObject instance = new BDObjectImpl();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.statementMostrar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BDObjectImpl extends BDObject {

        public PreparedStatement statementInserir() {
            return null;
        }

        public PreparedStatement statementDeletar() {
            return null;
        }

        public PreparedStatement statementAtualizar() {
            return null;
        }

        public PreparedStatement statementMostrar() {
            return null;
        }
    }
    
}
