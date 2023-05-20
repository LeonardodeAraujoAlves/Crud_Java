package cad_heroiseviloes;



import Controller.ConnectionManeira;
import View.Gui.Menu;
import View.Gui.TelaLogin;
import java.sql.Connection;
import java.sql.SQLException;
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
        //try {
        // CadHeroi cad = new CadHeroi();
       
        ConnectionManeira inst = ConnectionManeira.getInstancy();
        Connection con =  inst.getConexao();
        TelaLogin log = new TelaLogin();
        
    
        //Menu menu = new Menu();
        //} catch (ParseException ex) {
        //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
}
