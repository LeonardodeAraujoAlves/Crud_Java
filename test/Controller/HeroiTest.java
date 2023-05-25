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
public class HeroiTest {
    
    public HeroiTest() {
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
     * Test of inserir method, of class Heroi.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        String nome_heroi = "";
        String identidade_heroi = "";
        int idade_heroi = 0;
        double altura_heroi = 0.0;
        String inimigo_heroi = "";
        Heroi instance = new Heroi();
        instance.inserir(nome_heroi, identidade_heroi, idade_heroi, altura_heroi, inimigo_heroi);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of atualizar method, of class Heroi.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Heroi instance = new Heroi();
        instance.atualizar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class Heroi.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String nome = "";
        Heroi instance = new Heroi();
        instance.deletar(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class Heroi.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        Heroi instance = new Heroi();
        instance.mostrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
