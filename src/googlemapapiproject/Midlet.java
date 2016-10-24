/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlemapapiproject;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;

/**
 * @author Foued
 */
public class Midlet extends MIDlet implements CommandListener {
    Display disp = Display.getDisplay(this);
    List lst = new List("Examples", List.IMPLICIT);

    public void startApp() {
        lst.append("Simple Example", null);
        lst.append("Using Markers", null);
        lst.append("Using Paths", null);
        lst.append("Moving maps", null);
        lst.append("Zooming maps", null);
        lst.append("Using map in a Form", null);
        lst.setCommandListener(this);
        disp.setCurrent(lst);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c==List.SELECT_COMMAND)
        {
            switch(lst.getSelectedIndex())
			{
			case 0:
				disp.setCurrent(new GoogleMapsSimpleCanvas(this, d));
				break;
			case 1:
				disp.setCurrent(new GoogleMapsMarkerCanvas(this, d));
				break;
			case 2:
				disp.setCurrent(new GoogleMapsPathCanvas(this, d));
				break;
			case 3:
				disp.setCurrent(new GoogleMapsMoveCanvas(this, d));
				break;
			case 4:
				disp.setCurrent(new GoogleMapsZoomCanvas(this, d));
				break;
			case 5:
				disp.setCurrent(new GoogleMapsTestForm(this, d));
				break;
			}
        }
    }
}
