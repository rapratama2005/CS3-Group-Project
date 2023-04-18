/*
 import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    private JPanel topPanel;
    private JPanel bottomPanel;
    
    public GameGUI() {
        super("Comp Sci The Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create top panel with space-themed background and label centered
        topPanel = new JPanel(new GridBagLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("space.jpg"); // Replace with your own space-themed image
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        JLabel label = new JLabel("Comp Sci The Game", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        topPanel.add(label);
        
        // Create bottom panel with space-themed background and button centered
        bottomPanel = new JPanel(new GridBagLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("space.jpg"); // Replace with your own space-themed image
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
        JButton button = new JButton("Start");
        button.setPreferredSize(new Dimension(80, 30));
        button.setBorder(BorderFactory.createLineBorder(Color.RED));
        bottomPanel.add(button);
        
        // Add top and bottom panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GameGUI();
    }
}

 */
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
        
        setLayout(new GridLayout(1,1));
        GBattleScreen theGame = new GBattleScreen();
        ((Component)theGame).setFocusable(true);
        add(theGame);

        revalidate();
        repaint();
    }
}
