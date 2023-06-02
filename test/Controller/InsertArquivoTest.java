/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class InsertArquivoTest {
    
    public InsertArquivoTest() {
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
     * Test of run method, of class InsertArquivo.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        InsertArquivo instance = new InsertArquivo();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserirNoBanco method, of class InsertArquivo.
     */
    @Test
    public void testInserirNoBanco() {
        System.out.println("inserirNoBanco");
        String valores = "";
        InsertArquivo instance = new InsertArquivo();
        instance.inserirNoBanco(valores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
