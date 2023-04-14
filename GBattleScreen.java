import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GBattleScreen extends Canvas implements KeyListener, Runnable, ImageObserver {
    private BufferedImage back;
    GBattleScreen(){
        setBackground(Color.black);
        this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);

    }
    
    public void update(Graphics window) {
        paint(window); 
    }

    public void paintComponent(Graphics g){
        Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
        graphToBack.drawImage("Ivy.jpg", 100, 200, this);

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {   
    }
    public void keyTyped(KeyEvent e) {
        //no code needed here
      }
      public void run() {
        try {
            while(true) {
               Thread.currentThread().sleep(5);
             repaint();
          }
       }
        catch(Exception e) {
            
        }
        }
}
