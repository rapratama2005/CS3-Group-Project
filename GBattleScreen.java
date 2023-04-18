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
import java.awt.Image;

public class GBattleScreen extends Canvas implements KeyListener, Runnable  {
    private BufferedImage back;
    private Image deck;
    private Ivy i;
    GBattleScreen(){
        i = new Ivy();
        try {
            deck = ImageIO.read(new File("DeckPic.jpg"));
		}
		catch(Exception e) {
			System.out.println(e);
		}  
       
        setBackground(Color.black);
        this.addKeyListener(this);
        this.addMouseListener(new click());
		new Thread(this).start();
        setVisible(true);
    }
    
    //650  -  1281, max height and width
    public void update(Graphics window) {
        paint(window); 
    }

    public void paint(Graphics window){
        Graphics2D twoDGraph = (Graphics2D)window;
        //height and width scale factors
        //double h = getHeight()/650;
        //double w = getWidth()/1281;
		
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
		graphToBack.fillRect(0,0,1010,690);
        i.draw(graphToBack);
        graphToBack.drawImage(deck,20,0,20,20,null);
        graphToBack.setColor(Color.green);
        graphToBack.drawRect(20,20,200,200);
        graphToBack.drawRect(1061,20,200,200);
        graphToBack.drawRect(20,260,200,200);
        graphToBack.drawRect(1061,260,200,200);

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {   
    }
    public void keyTyped(KeyEvent e) {
        //no code needed here
      }
    class click extends MouseAdapter{
        public void mousePressed(MouseEvent m){
            System.exit(0);
        }
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
