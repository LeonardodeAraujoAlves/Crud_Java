package cad_heroiseviloes;

import View.Gui.CadHeroi;
import View.Gui.Menu;
import View.Gui.TelaLogin;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L.A.A
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CadHeroi cad = new CadHeroi();
            //TelaLogin log = new TelaLogin();
             new Menu();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
