import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class GMainScreen extends JFrame implements ActionListener{
    final int WIDTH = 1920;
    final int HEIGHT = 1080;
    private JPanel gUpper;
    private JPanel gLower;
    public static void main(String[] args){
        JFrame mainy = new GMainScreen();
    }

    GMainScreen(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("COMP SCI, THE CARD GAME, presented by team (a)MiRiCa");
        setLayout(new GridLayout(2, 1));
        gUpper = new JPanel();
        gUpper.setLayout(new FlowLayout());
        gUpper.setOpaque(true);
        gUpper.setBackground(Color.black);
        JLabel title = new JLabel("Comp Sci The Game");
        title.setFont(new Font("Georgia", Font.BOLD, 25));
        title.setForeground(Color.green);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setAlignmentY(CENTER_ALIGNMENT);
        gUpper.add(title);
        add(gUpper);

        gLower = new JPanel();
        gLower.setLayout(null);
        JButton start = new JButton("Start");
        start.setSize(500, 250);
        start.setLocation(636-start.getWidth() / 2, 164-start.getHeight() / 2);
        start.setForeground(Color.CYAN);
        start.setBackground(Color.ORANGE);
        start.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
        start.addActionListener(this);
        gLower.add(start);
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
