
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class GMainScreen extends JFrame {
    private JLabel title;
    private JButton start;
    public GMainScreen() {
        setTitle("Comp Sci the Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon a = new ImageIcon("space.jpg");
        JLabel b = new JLabel(a);
        b.setBounds(0, 0, 800, 600);
        add(b);
        title = new JLabel("Comp Sci the Game");
        title.setForeground(Color.GREEN);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250, 50, 300, 50);
        b.add(title);
        start = new OvalButton("Start");
        start.setForeground(Color.cyan);
        start.setOpaque(false);
        start.setBackground(Color.red);
        start.setFont(new Font("Arial", Font.PLAIN, 18));
        start.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        start.setBounds(350, 500, 100, 50);
        b.add(start);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GMainScreen();
    }
    public class OvalButton extends JButton {
        public OvalButton(String text) {
            super(text);
            setOpaque(false);
            setPreferredSize(new Dimension(100, 50));
        }
        public void paintComponent(Graphics g) {
            Graphics2D a = (Graphics2D) g.create();
            a.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            a.setColor(getBackground());
            a.fillOval(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
            a.dispose();
        }
        public void paintBorder(Graphics g) {
            Graphics2D a = (Graphics2D) g.create();
            a.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            a.setColor(getForeground());
            a.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
            a.dispose();
        }
    }
    /*public void actionPerformed(ActionEvent e){
        remove(upper);
        remove(lower);
        setLayout(new GridLayout(1,1));
        GBattleScreen theGame = new GBattleScreen();
        ((Component)theGame).setFocusable(true);
        add(theGame);
    
        revalidate();
        repaint();
    }*/
}