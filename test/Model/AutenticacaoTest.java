/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class AutenticacaoTest {
    
    public AutenticacaoTest() {
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
     * Test of Acessa method, of class Autenticacao.
     */
    @Test
    public void testAcessa() {
        String nome = "yuyu";
        String senha = "1234";
        Autenticacao instance = new Autenticacao(nome, senha);
        boolean expResult = false;
        boolean result = instance.Acessa(nome, senha);
        assertEquals(expResult, result);//o resultado esperado é que não seja permitida a realização do login
    }
    
}
