import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GBattleScreen2 extends JFrame{
    private JPanel card1,card2,card3,card4,hand1,hand2;
    //left sides
    private JPanel c1, c2, c3, c4;
    //picture JPanels
    private JPanel p1,p2,p3,p4;
    private JLabel card1P,card2P,card3P,card4P;
    private JTextArea D1,D2,D3,D4;
    private JPanel a1,a2,a3,a4;
    private ArrayList<JButton> atks = new ArrayList<JButton>();
    private JButton at1,bat1,at2,bat2,at3,bat3,at4,bat4;
    private JButton selected;
    private JButton prevSel;

    GBattleScreen2(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        
        card1 = new JPanel();
        card1.setLayout(new GridLayout(1,2));
        //left side
        c1 = new JPanel();
        c1.setLayout(new GridLayout(2,1));
        card1.add(c1);

        p1 = new JPanel();
        card1P = new JLabel();
        p1.add(card1P);
        c1.add(p1);
        D1 = new JTextArea(10,15);
        JScrollPane s1 = new JScrollPane(D1);
        c1.add(s1);
        //right side
        a1 = new JPanel();
        card1.add(a1);
        atks.add(new JButton("attack"));
        a1.add(atks.get(0));
        atks.get(0).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a1.add(atks.get(1));
        atks.get(1).addActionListener(new act());
        add(card1);

        card2 = new JPanel();
        card2.setLayout(new GridLayout(1,2));
        //left side
        c2 = new JPanel();
        c2.setLayout(new GridLayout(2,1));
        card2.add(c2);
        
        card2P = new JLabel();
        c2.add(card2P);
        D2 = new JTextArea(10,15);
        JScrollPane s2 = new JScrollPane(D2);
        c2.add(s2);
        //right side
        a2 = new JPanel();
        card2.add(a2);
        atks.add(new JButton("attack"));
        a2.add(atks.get(2));
        atks.get(2).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a2.add(atks.get(3));
        atks.get(3).addActionListener(new act());
        add(card2);

        card3 = new JPanel();
        card3.setLayout(new GridLayout(1,2));
        //left side
        c3 = new JPanel();
        c3.setLayout(new GridLayout(2,1));
        card3.add(c3);
        card3P = new JLabel();
        c3.add(card3P);
        D3 = new JTextArea(10,15);
        JScrollPane s3 = new JScrollPane(D3);
        c3.add(s3);
        //right side
        a3 = new JPanel();
        card3.add(a3);
        atks.add(new JButton("attack"));
        a3.add(atks.get(4));
        atks.get(4).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a3.add(atks.get(5));
        atks.get(5).addActionListener(new act());
        add(card3);
        
        card4 = new JPanel();
        card4.setLayout(new GridLayout(1,2));
        //left side
        c4 = new JPanel();
        c4.setLayout(new GridLayout(2,1));
        card4.add(c4);
        card4P = new JLabel();
        c4.add(card4P);
        D4 = new JTextArea(10,15);
        JScrollPane s4 = new JScrollPane(D4);
        c4.add(s4);
        //right side
        a4 = new JPanel();
        card4.add(a4);
        atks.add(new JButton("attack"));
        a4.add(atks.get(6));
        atks.get(6).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a4.add(atks.get(7));
        atks.get(7).addActionListener(new act());
        add(card4);
        setVisible(true);
    }

    class act implements ActionListener{
        public void actionPerformed(ActionEvent e){
            selected = (JButton)e.getSource();
            int ind = atks.indexOf(selected);
            atks.get(ind).setBackground(Color.green);
            if (prevSel!=null&&prevSel!=selected){
                atks.get(atks.indexOf(prevSel)).setBackground(Color.white);
            }
            int h = ind/2;
            if (h==0){
                p1.remove(card1P);
                ImageIcon a = new ImageIcon("space.jpg");
                card1P = new JLabel(a);
                p1.add(card1P);
            }
            else if (h==1){
                ImageIcon a = new ImageIcon("space.jpg");
                card2P = new JLabel(a);
                card2P.setBounds(0, 0, 800, 600);
                add(card2P);
            }
            else if (h==2){
                ImageIcon a = new ImageIcon("space.jpg");
                card2P = new JLabel(a);
                card2P.setBounds(0, 0, 800, 600);
                add(card2P);
            }
            else if (h==3){
                ImageIcon a = new ImageIcon("space.jpg");
                card2P = new JLabel(a);
                card2P.setBounds(0, 0, 800, 600);
                add(card2P);
            }

            prevSel = selected;
            revalidate();
            repaint();
        }
    }

    public static void main(String[] args){
        GBattleScreen2 run = new GBattleScreen2();
    }
}
