/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
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
public class ConnectionSingletonTest {
    /**
     * Test of getInstance method, of class ConnectionSingleton.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ConnectionSingleton expResult = ConnectionSingleton.getInstance();
        ConnectionSingleton result = ConnectionSingleton.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertSame(expResult, result);
    }

    /**
     * Test of getConexao method, of class ConnectionSingleton.
     */
    @Test
    public void testGetConexao() {
        System.out.println("getConexao");
        ConnectionSingleton instance = ConnectionSingleton.getInstance();
        Connection con = instance.getConexao();
        assertNotNull(con);
    }
    
}
