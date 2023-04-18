
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GMainScreen extends JFrame {
    private JPanel upper;
    private JPanel image;
    private JPanel lower;
    public GMainScreen() {
        super("Comp Sci The Game");
        setSize(1010, 690);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create top panel with space-themed background and label centered
        upper = new JPanel(new GridBagLayout()) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("space.jpg"); // Replace with your own space-themed image
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        JLabel label = new JLabel("Comp Sci The Game", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        upper.add(label);
        image = new JPanel(new GridBagLayout()) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("space.jpg"); // Replace with your own space-themed image
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        // Create bottom panel with space-themed background and button centered
        lower = new JPanel(new GridBagLayout()) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("space.jpg"); // Replace with your own space-themed image
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        JButton button = new JButton("Start");
        button.setPreferredSize(new Dimension(80, 30));
        button.setSize(500, 250);
        button.setForeground(Color.CYAN);
        button.setBackground(Color.ORANGE);
        button.setBorder(BorderFactory.createLineBorder(Color.RED));
        lower.add(button);
        // Add top and bottom panels to frame
        add(upper, BorderLayout.NORTH);
        add(image, BorderLayout.CENTER);
        add(lower, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GMainScreen();
    }
/*
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
    }*/
    public void actionPerformed(ActionEvent e){
        remove(upper);
        remove(lower);
        
        setLayout(new GridLayout(1,1));
        GBattleScreen theGame = new GBattleScreen();
        ((Component)theGame).setFocusable(true);
        add(theGame);

        revalidate();
        repaint();
    }
}
