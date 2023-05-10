import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GVictoryScreen extends JFrame{
    private ImageIcon a = null;
    private JLabel pic;
    GVictoryScreen(boolean redWin){
        super();
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,1));
        if(!redWin){
            a = new ImageIcon("redwins.png");
        } else {
            a = new ImageIcon("bluewins.png");
        }
        pic = new JLabel(a);
        pic.setVisible(true);
        add(pic);
        setVisible(true);

    }
}
