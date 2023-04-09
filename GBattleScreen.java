import javax.swing.*;
import java.awt.*;

public class GBattleScreen extends JFrame{
    final int WIDTH = 1920;
    final int HEIGHT = 1080;
    public static void main (String[] args){
        JFrame GBattleScreen = new GBattleScreen();
    }

    GBattleScreen(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("COMP SCI, THE CARD GAME, presented by team (a)MiRiCa");
        setLocation(50,100);
        GridLayout jfLay = new GridLayout(2, 0);
        setLayout(jfLay);

        GUpper gUpper = new GUpper();
        add(gUpper);

        GLower gLower = new GLower();
        add(gLower);

        //End
        setVisible(true);
    }

    private class GUpper extends GPanel{
        GUpper() {
            super(WIDTH, HEIGHT / 2, 1, 3, Color.gray);
           
        }
    }

    private class GLower extends GPanel{

        GLower() {
            super(WIDTH, HEIGHT / 2, 2, 1, Color.white);
        }

    }
}
