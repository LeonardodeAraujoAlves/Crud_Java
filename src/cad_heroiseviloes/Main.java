package cad_heroiseviloes;

import View.Gui.Heroi.AtualizaHeroi;
import View.Gui.Login.TelaLogin;
import View.Gui.User.AtualizarUsuario;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Esta classe é responsável por iniciar a aplicação
 * @author L.A.A
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TelaLogin Login = new TelaLogin();
            new AtualizaHeroi();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
