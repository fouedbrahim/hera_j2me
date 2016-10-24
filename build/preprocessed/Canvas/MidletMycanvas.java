package Canvas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.*;

/**
 * @au
 */
public class MidletMycanvas extends MIDlet {
    Display disp=Display.getDisplay(this);
    

    public void startApp() {
      disp.setCurrent(new Mycanvas());
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}