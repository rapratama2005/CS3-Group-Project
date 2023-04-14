import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class GMainScreen extends JFrame implements ActionListener{
    final int WIDTH = 1920;
    final int HEIGHT = 1080;
    private GUpper gUpper;
    private GLower gLower;
    public static void main(String[] args){
        JFrame mainy = new GMainScreen();
    }

    GMainScreen(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("COMP SCI, THE CARD GAME, presented by team (a)MiRiCa");
        GridLayout jfLay = new GridLayout(2, 1);
        setLayout(jfLay);

        gUpper = new GUpper();
        add(gUpper);

        gLower = new GLower();
        add(gLower);

        //End
        setVisible(true);
    }   

    /*private class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }/* */
    private class GUpper extends GPanel{
        GUpper() {
            super(WIDTH, HEIGHT / 2, 1, 1, Color.gray);
            JLabel fil = new JLabel();
            add(fil);

            JLabel title = new JLabel("Comp Sci The Game");
            title.setFont(new Font("Georgia", Font.BOLD, 25));
            title.setForeground(Color.green);
            add(title);

            JLabel fil2 = new JLabel();
            add(fil2);
        }
    }
    private class GLower extends GPanel{

        GLower() {
            super(WIDTH, HEIGHT / 2, 2, 1, Color.white);
            setLayout(null);
            JButton start = new JButton("Start");
            start.setSize(500, 250);
            start.setLocation(636-start.getWidth() / 2, 164-start.getHeight() / 2);
            start.setForeground(Color.CYAN);
            start.setBackground(Color.ORANGE);
            start.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
            start.addActionListener(this());
            add(start);
        }
    }

    class RunBattle extends JFrame {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;
    
        public RunBattle() {
            super("Battling");
            setSize(WIDTH,HEIGHT);
    
            GBattleScreen theGame = new GBattleScreen();
            ((Component)theGame).setFocusable(true);
    
            getContentPane().add(theGame);
            setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e){
        remove(gUpper);
        remove(gLower);
        
        GBattleScreen theGame = new GBattleScreen();
        ((Component)theGame).setFocusable(true);
        add(theGame);

        revalidate();
        repaint();
    }
}
