package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe responsável por realizar os testes unitários 
 * dos métodos da classe Autenticacao
 *
 * @author L.A.A
 */
public class AutenticacaoTest {

    public AutenticacaoTest() {
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

        String nomeCadastrado = "root";//dados que existem no banco de dados
        String senhaCadastrada = "1234";
        Autenticacao instance2 = new Autenticacao(nomeCadastrado, senhaCadastrada);

        boolean expResult2 = true;
        boolean result2 = instance2.Acessa(nomeCadastrado, senhaCadastrada);

        assertEquals(expResult2, result2);// O resultado esperado é que seja permitida a realização do login
    }

}
