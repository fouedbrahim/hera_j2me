/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeEvents;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;

public class MidletAjout extends MIDlet implements CommandListener, Runnable{

    Display disp = Display.getDisplay(this);
    
    //Form 1
    Form f1 = new Form("Inscription");
    TextField tfNom = new TextField("Titre", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("type", null, 100, TextField.ANY);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");

    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);

    //Connexion
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://127.0.0.1/hera_parsing/ajout.php";
    StringBuffer sb = new StringBuffer();
    int ch;

   public MidletAjout() {
       
    }

    public void startApp() {
       //  disp.setCurrent(new SplashScreen(this));
        f1.append(tfNom);
        f1.append(tfPrenom);
        f1.addCommand(cmdValider);
        f1.setCommandListener(this);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
        disp.setCurrent(f1);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdValider) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack) {
            
            disp.setCurrent(f1);
        }
    }

    public void run() {
        try {
                hc = (HttpConnection) Connector.open(url+"?Titre="+tfNom.getString().trim()+"&type="+tfPrenom.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(f2);
                }else{
                    disp.setCurrent(f3);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
   }
}
