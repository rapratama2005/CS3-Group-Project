import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GBattleScreen2 extends JFrame{
    private JPanel card1,card2,card3,card4,hand1,hand2;
    private JPanel card1P,card2P,card3P,card4P;
    private JTextArea D1,D2,D3,D4;

    GBattleScreen2(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        card1 = new JPanel();
        card1.setLayout(new GridLayout(1,2));
        JPanel c1 = new JPanel();
        c1.setLayout(new GridLayout(2,1));
        card1.add(c1);
        card1P = new JPanel();
        c1.add(card1P);
        D1 = new JTextArea(10,15);
        JScrollPane s1 = new JScrollPane(D1);
        c1.add(s1);
        add(card1);

        card2 = new JPanel();
        card2.setLayout(new GridLayout(1,2));
        JPanel c2 = new JPanel();
        c2.setLayout(new GridLayout(2,1));
        card2.add(c2);
        card2P = new JPanel();
        c2.add(card2P);
        D2 = new JTextArea(10,15);
        JScrollPane s2 = new JScrollPane(D2);
        c2.add(s2);
        add(card2);

        card3 = new JPanel();
        card3.setLayout(new GridLayout(1,2));
        JPanel c3 = new JPanel();
        c3.setLayout(new GridLayout(2,1));
        card3.add(c3);
        card3P = new JPanel();
        c3.add(card3P);
        D3 = new JTextArea(10,15);
        JScrollPane s3 = new JScrollPane(D3);
        c3.add(s3);
        add(card3);
        
        card4 = new JPanel();
        card4.setLayout(new GridLayout(1,2));
        JPanel c4 = new JPanel();
        c4.setLayout(new GridLayout(2,1));
        card4.add(c4);
        card4P = new JPanel();
        c4.add(card4P);
        D4 = new JTextArea(10,15);
        JScrollPane s4 = new JScrollPane(D4);
        c4.add(s4);
        add(card4);
        
        
    }
}
