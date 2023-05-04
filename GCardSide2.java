import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.border.*;
import javax.swing.event.*;

public class GCardSide2 extends GPanel{
    private JComboBox box = new JComboBox();
    private JPanel pan = new JPanel();
    private JLabel pic;
    private JTextArea tex = new JTextArea(10,15);
    private DsuperCard card;
    private JButton confirm = null;
    DDeck deck = new DDeck();

    GCardSide2() {
        super(WIDTH, HEIGHT, 2, 1, Color.white);
        
        
        box.addItem(deck.draw().getName());
        box.addItem(deck.draw().getName());
        box.addItem(deck.draw().getName());
        box.addItem(deck.draw().getName());
        box.addActionListener(new boxes(1));
        pan.add(box);
        add(pan);

        tex.setEditable(false);
        JScrollPane s1 = new JScrollPane(tex);
        add(s1);

    }

    class boxes implements ActionListener{
        private int cN;
        public boxes(int num){
            cN=num;
        }
        public void actionPerformed(ActionEvent e){
            String selected = (String)((JComboBox)e.getSource()).getSelectedItem();
            if (confirm!=null){
                ((confirmCard)confirm.getActionListeners()[0]).setS(selected);
            }
            else{
                confirm = new JButton("Confirm");
                confirm.setBackground(Color.gray);
                confirm.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
                Border border = new LineBorder(Color.green,3,true);
                confirm.setForeground(Color.yellow);
                confirm.setBorder(border);
                pan.add(confirm);
                confirm.addActionListener(new confirmCard(selected));
            }
            tex.setText(deck.cardID(selected).getDesc(0));
            revalidate();
            repaint();
        }
    }

    class confirmCard implements ActionListener{
        private String sel;
        public confirmCard(String s){
            sel=s;
        }
        public void setS(String s){
            sel = s;
        }
        public void actionPerformed(ActionEvent e){
            DsuperCard car = deck.cardID(sel);
            card = car;
            changeImage(car.getImgSource());
            //field.add(car);
            pan.remove(confirm);
            pan.remove(box);
            tex.setText("");
        }
        public void changeImage(String fileN){
            ImageIcon a = new ImageIcon(fileN);
            pic = new JLabel(a);
            pan.add(pic);
            revalidate();
            repaint();
            }
    }
    public DsuperCard getCard(){
        return card;
    }
    public void setT(String t){
        tex.setText(t);
    }
}
