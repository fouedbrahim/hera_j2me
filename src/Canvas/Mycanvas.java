package Canvas;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author foued
 */
public class Mycanvas extends Canvas {

    int w=getWidth();
    int h=getHeight();
    Image img;
    
     
    protected void paint(Graphics g){
        

try {
img = Image.createImage ("Images/img.png");
}
catch (Exception e) {
e.printStackTrace();
}

    
    g.setColor(255,255,255);
    g.fillRect(0, 0, w, h);
    g.setColor(255, 0 , 0);
  //  un carre au milie g.fillRect(w/2-20 , w/2-20 , 40 , 40);
  
    //cercle 
    g.fillArc(w/2-50 , h/2-50 ,100 , 100,0,360);
    g.setColor(0, 0 , 0);
    g.drawLine(w/2,0, w/2, h);
    g.drawLine(0,h/2,w,h/2);
    //text  esprit en bas
//g.drawString("TOP Left ", 0, 0, Graphics.TOP | Graphics.LEFT);
//g.drawString("TOP Right", w, 0 ,Graphics.TOP | Graphics.RIGHT);
//g.drawString("Button left", 0, h,Graphics.BOTTOM | Graphics.LEFT);
//g.drawString("Button right", w, h,Graphics.BOTTOM | Graphics.RIGHT);
//g.drawString("center", w / 2, h / 2,Graphics.BASELINE |Graphics.HCENTER);
    

g.drawImage (img, 0, 0, Graphics.TOP | Graphics.LEFT);
g.drawImage (img, getWidth () / 2, getHeight () / 2, Graphics.HCENTER |Graphics.VCENTER);
g.drawImage (img, getWidth (), getHeight (),Graphics.BOTTOM | Graphics.RIGHT);

    
    }
 

}


    
    