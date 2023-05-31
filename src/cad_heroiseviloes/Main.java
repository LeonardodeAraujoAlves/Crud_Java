package cad_heroiseviloes;

import Controller.InsertArquivo;
import View.Gui.Login.TelaLogin;

/**
 *Esta classe é responsável por iniciar a aplicação
 * @author L.A.A
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             TelaLogin Login = new TelaLogin();
             
             InsertArquivo arq = new InsertArquivo();
             Thread baguioDoido = new Thread(arq);
             baguioDoido.start();
    }
    
}
