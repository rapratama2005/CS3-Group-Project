import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GBattleScreen2 extends JFrame{
    private JPanel card1,card2,card3,card4,hand1,hand2;
    GBattleScreen2(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        card1,card2,card3,card4 = new JPanel();
    }
}
