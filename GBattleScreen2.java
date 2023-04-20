import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GBattleScreen2 extends JFrame{
    private JPanel card1,card2,card3,card4,hand1,hand2;
    GBattleScreen2(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        card1 = new JPanel();
        card1.setLayout(new GridLayout(1,2));

        card2 = new JPanel();
        card2.setLayout(new GridLayout(1,2));

        card3 = new JPanel();
        card3.setLayout(new GridLayout(1,2));
        
        card4 = new JPanel();
        card4.setLayout(new GridLayout(1,2));
        
        
    }
}
