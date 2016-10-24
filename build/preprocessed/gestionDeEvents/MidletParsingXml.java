/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionDeEvents;

import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Houssem Eddine
 */
public class MidletParsingXml extends MIDlet implements CommandListener, Runnable {

    Display disp = Display.getDisplay(this);
    Command cmdParse = new Command("Evennements", Command.SCREEN, 0);
    
    Command cmdBack = new Command("Back", Command.BACK, 0);
    evennement[] evennements;
    List lst = new List("Evennements", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form form = new Form("Infos Evennements");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();

    public void startApp() {
        f.append("Click Evennements to get your Evennements_list");
        f.addCommand(cmdParse);
        f.setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        disp.setCurrent(f);
        
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdParse) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Evennements: \n");
            form.append(showPersonne(lst.getSelectedIndex()));
            disp.setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            disp.setCurrent(lst);
        }

    }

    public void run() {
        try {
            // this will handle our XML
           EvennementHandler eventsHandler = new EvennementHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://127.0.0.1/hera_parsnig/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, eventsHandler);
            // display the result
         evennements  = eventsHandler.getEvents();

            if (evennements.length > 0) {
                for (int i = 0; i < evennements.length; i++) {
                    lst.append(evennements[i].getTitre()+" "
                            +evennements[i].getDescription()+" "
                            +evennements[i].getEtat()+" "
                            +evennements[i].getIdSalle()+" "
                            +evennements[i].getType()+" "
                            +evennements[i].getDate()+" "
                            , null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lst);
    }

    private String showPersonne(int i) {
        String res = "";
        if (evennements.length > 0) {
            sb.append("* ");
            sb.append(evennements[i].getTitre());
            sb.append("\n");
            sb.append("* ");
            sb.append(evennements[i].getEtat());
            sb.append("\n");
           
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}
