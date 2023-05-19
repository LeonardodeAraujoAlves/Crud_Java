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
public class ConnectionTest {
    
    public ConnectionTest() {
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
     * Test of insereHeroi method, of class Connection.
     */
    @Test
    public void testInsereHeroi() {
        System.out.println("insereHeroi");
        String nome_heroi = "";
        String identidade_heroi = "";
        int idade_heroi = 0;
        double altura_heroi = 0.0;
        String inimigo_heroi = "";
        Heroi h = new Heroi(nome_heroi, identidade_heroi, idade_heroi, altura_heroi, inimigo_heroi);
        h.inserir(nome_heroi, identidade_heroi, idade_heroi, altura_heroi, inimigo_heroi);
    }

    /**
     * Test of insereVilao method, of class Connection.
     */
    @Test
    public void testInsereVilao() {
        System.out.println("insereVilao");
        String nome_vilao = "";
        String organizacao_vilao = "";
        double altura_vilao = 0.0;
        String inimigo_vilao = "";
        String lugar_principal = "";
        String arma = "";
        int quant_vitimas = 0;
        String mascote_vilao = "";
        Connection.insereVilao(nome_vilao, organizacao_vilao, altura_vilao, inimigo_vilao, lugar_principal, arma, quant_vitimas, mascote_vilao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
