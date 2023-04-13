import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GMainScreen extends JFrame{
    final int WIDTH = 1920;
    final int HEIGHT = 1080;
    private GUpper gUpper;
    private GLower gLower;
    public static void main (String[] args){
        JFrame main = new GMainScreen();
    }

    GMainScreen(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("COMP SCI, THE CARD GAME, presented by team (a)MiRiCa");
        GridLayout jfLay = new GridLayout(2, 0);
        setLayout(jfLay);

        gUpper = new GUpper();
        add(gUpper);

        gLower = new GLower();
        add(gLower);

        //End
        setVisible(true);
    }

    private class GUpper extends GPanel{
        GUpper() {
            super(WIDTH, HEIGHT / 2, 1, 3, Color.gray);
            JLabel fil = new JLabel();
            add(fil);

            JLabel title = new JLabel("Comp Sci the Game");
            title.setFont(new Font("Georgia", Font.BOLD, 25));
            title.setForeground(Color.green);
            title.setAlignmentX(CENTER_ALIGNMENT);
            add(title);

            JLabel fil2 = new JLabel();
            add(fil2);
        }
    }

    private class GLower extends GPanel{

        GLower() {
            super(WIDTH, HEIGHT / 2, 2, 1, Color.white);
            JButton start = new JButton("Start");
            start.setSize(200, 100);
            start.setForeground(Color.CYAN);
            start.setBackground(Color.ORANGE);
            start.addActionListener(new stGame());
            add(start);
        }
    }
    class stGame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            remove(gUpper);
            remove(gLower);
            setLayout(new FlowLayout());
            revalidate();
            repaint();
        }
    }
}
