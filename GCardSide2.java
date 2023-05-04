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
    private JButton confirm;
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
        add(tex);

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
                confirm.addActionListener(new confirmCard(selected,1));
            }
            tex.setText(deck.cardID(selected).getDesc(0));
        }
    }

    class confirmCard implements ActionListener{
        private String sel;
        private int i;
        public confirmCard(String s, int num){
            sel=s;
            i = num;
        }
        public void setS(String s){
            sel = s;
        }
        public void actionPerformed(ActionEvent e){
            DsuperCard car = deck.cardID(sel);
            card = car;
            //field.add(car);
            pan.remove(confirm);
            pan.remove(box);
            tex.setText("");
            /*
                changeImage(1,car.getImgSource());
                atks.get(0).setText(car.getAName());
                atks.get(1).setText(car.getBName());
                currH.get(0).setText("  "+car.getHealth());
                currA.get(0).setText(""+car.getAtk()+"  ");
                supBar1.setMB(car.getSupReq());
                supBar1.setT(car.getDesc(3));
            }
            else if(i==2){
                p2.remove(confirms.get(2));
                confirms.remove(2);
                p2.remove(box2);
                D2.setText("");
                changeImage(2,car.getImgSource());
                atks.get(2).setText(car.getAName());
                atks.get(3).setText(car.getBName());
                currH.get(1).setText("  "+car.getHealth());
                currA.get(1).setText(""+car.getAtk()+"  ");
                supBar2.setMB(car.getSupReq());
                supBar2.setT(car.getDesc(3));
            }
            else if (i==3){
                p3.remove(confirms.get(3));
                confirms.remove(3);
                p3.remove(box3);
                D3.setText("");
                changeImage(3,car.getImgSource());
                atks.get(4).setText(car.getAName());
                atks.get(5).setText(car.getBName());
                currH.get(2).setText("  "+car.getHealth());
                currA.get(2).setText(""+car.getAtk()+"  ");
                supBar3.setMB(car.getSupReq());
                supBar3.setT(car.getDesc(3));
            }
            else if (i==4){
                p4.remove(confirms.get(4));
                confirms.remove(4);
                p4.remove(box4);
                D4.setText("");
                changeImage(4,car.getImgSource());
                atks.get(6).setText(car.getAName());
                atks.get(7).setText(car.getBName());
                currH.get(3).setText("  "+car.getHealth());
                currA.get(3).setText(""+car.getAtk()+"  ");
                supBar4.setMB(car.getSupReq());
                supBar4.setT(car.getDesc(3));
            }
            turn++;
            System.out.println(field);
        }
        */
    }
    
}
