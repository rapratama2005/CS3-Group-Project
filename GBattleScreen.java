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
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;


public class GBattleScreen extends Canvas implements KeyListener, Runnable {
    private BufferedImage back;
    private ImageIcon ivy;
    //private Image ivy2;
    GBattleScreen(){
        try {
			ivy = new ImageIcon("Ivy.jpg");
            //ivy2 = ImageIO.read(new File("Ivy.jpg"));
		}
		catch(Exception e) {
			System.out.println(e);
		}    
        setBackground(Color.black);
        this.addKeyListener(this);
		new Thread(this).start();
        setVisible(true);
    }
    
    public void update(Graphics window) {
        paint(window); 
    }

    public void paintComponent(Graphics window){
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
        
        graphToBack.drawImage(ivy.getImage(), 0, 0,100,100, null);
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
