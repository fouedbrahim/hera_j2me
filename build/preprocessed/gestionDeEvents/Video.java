package gestionDeEvents;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
public class Video extends Form implements CommandListener, PlayerListener, Runnable { 
   private Display display; 
   private Command stop = new Command("Stop",Command.SCREEN, 2); 
   public static Player player; 
  static Video videoPlayer;
   public Video(String s) { 
     super(" Playing a Video file "); 
    videoPlayer = this; 
     start(); 
    addCommand(stop); 
     setCommandListener(this);
  } 
   public void playerUpdate(Player player,String event, Object data) { 
     if(event == PlayerListener.END_OF_MEDIA) { 
        try { 
        defplayer(); 
      } catch(MediaException me) { 
        } 
    reset(); 
    } 
  }
   public void commandAction(Command c, Displayable d) { 
   
    if(c == stop) { 
      stopPlayer(); 
      // TO-DO perform some action 
     } 
  }
     public void start() { 
      Thread t = new Thread(this); 
      t.start(); 
    } 
  public void run() { 
    play(); 
  } 
  void play() { 
    try { 
      VideoControl vc; 
      defplayer(); 
      // specify the location of the media file
    player = Manager.createPlayer(getClass().getResourceAsStream("/video/1.mpg"),"/video/1.mpg");       player.addPlayerListener(this); 
      // realize the player 
      player.realize(); 
      vc = (VideoControl)player.getControl("VideoControl"); 
    if(vc != null) { 
      Item video = (Item)vc.initDisplayMode(vc.USE_GUI_PRIMITIVE, null);        append(video); 
    } 
    player.prefetch(); 
    player.start(); 
  } catch(Throwable t) { 
      reset(); 
    Alert al = new Alert("Error", t.getMessage(), null, AlertType.ERROR);     display.setCurrent(al); 
    t.printStackTrace(); 
    } 
  }
   public static void defplayer() throws MediaException { 
    if (player != null) { 
      if(player.getState() == Player.STARTED) { 
        player.stop(); 
    } if(player.getState() == Player.PREFETCHED) { 
        player.deallocate(); 
       } 
    if(player.getState() == Player.REALIZED || player.getState() == Player.UNREALIZED){        player.close(); 
    } 
  } 
    player = null; 
  }
   public static void reset() {
    player = null;
  }
   void stopPlayer() { 
    try { 
      defplayer(); 
    } catch(MediaException me) { 
      } 
    reset(); 
  }
}