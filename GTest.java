import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
public class GTest extends JFrame{
    public static void main(String args[]){
        GTest s = new GTest();
    }

    GTest(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,1));
        GCard card = new GCard(false, 1);
        add(card);
        
        setVisible(true);
    }
}