package cad_heroiseviloes;



import Controller.ConnectionSingleton;
import View.Gui.Heroi.DeletaHeroi;
import View.Gui.Menu.Menu;
import View.Gui.Login.TelaLogin;
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
       
       // ConnectionSingleton inst = ConnectionSingleton.getInstancy();
        //Connection con =  inst.getConexao();
       // TelaLogin log = new TelaLogin();
        DeletaHeroi del = new DeletaHeroi();
    
        //Menu menu = new Menu();
        //} catch (ParseException ex) {
        //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
}
