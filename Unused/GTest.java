package Unused;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
public class GTest extends JFrame{
    public static void main(String args[]){
        GTest s = new GTest();
    }

    GTest(){
        super();
        setSize(new Dimension(1920, 1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,1));
        GCard card = new GCard(false,1, 1);
        add(card);
        
        setVisible(true);
    }
}