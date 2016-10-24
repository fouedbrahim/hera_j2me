package gestionDeEvents;



/**
 * @author sana
 */
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

public class ProjectMIDlet extends MIDlet{
    
    private Display display = Display.getDisplay(this);
    public ProjectMIDlet() {}
    public void startApp() {
        
            
        
        display.setCurrent(new SplashScreen(this));
    }
    public void pauseApp() {}
    public void destroyApp(boolean unconditional) {}
}
