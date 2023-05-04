import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.border.*;
import javax.swing.event.*;

public class GCardSide1 extends GPanel{
    GCardStats hp = new GCardStats("Health", 1);
    GCardStats at = new GCardStats("Base Attack", 1);
    GPanel hpAtk = new GPanel(WIDTH, HEIGHT, 1, 2, Color.white);
    private JButton atk, batk, confirm;
    //private superCharge superbar = new superCharge(3,1)
    private JPanel stats = new JPanel();


    GCardSide1() {
        super(WIDTH, HEIGHT, 5, 1, Color.white);
        hpAtk.add(hp);
        hpAtk.add(at);
        add(hpAtk);

        stats.setLayout(new GridLayout(1,3));
        stats.add(hp);
        //stats.add(name);
        stats.add(at);

        /*
        currH.get(0).setHorizontalAlignment(JLabel.LEFT);
        currH.get(0).setHorizontalTextPosition(JLabel.LEFT);
        //currH.get(0).setVerticalAlignment(JLabel.TOP);
        //currH.get(0).setVerticalTextPosition(JLabel.TOP);
        currA.get(0).setHorizontalAlignment(JLabel.RIGHT);
        currA.get(0).setHorizontalTextPosition(JLabel.RIGHT);
        //currA.get(0).setVerticalAlignment(JLabel.TOP);
        //currA.get(0).setVerticalTextPosition(JLabel.TOP);
        */
        atk = new JButton("attack");
        atk.setBackground(Color.white);
        //atk.addActionListener(new act());
        add(atk);
        batk = new JButton("B attack");
        batk.setBackground(Color.white);
        add(batk);
        //batk.addActionListener(new act());
        
        //add(superbar);
    }
/*
    public void selColor(int ind, int h){
        atks.get(ind).setBackground(Color.green);
        if (prevSel!=null&&prevSel!=selected){
            atks.get(atks.indexOf(prevSel)).setBackground(Color.white);
        }
        addConfirm(ind, h);
    }
   
    class act implements ActionListener{
        public void actionPerformed(ActionEvent e){
            selected = (JButton)e.getSource();
            int ind = atks.indexOf(selected);
            int h = ind/2;
            supBar1.fillBar();
            supBar1.fillBar();
            supBar1.fillBar();
            supBar1.fillBar();
            supBar1.fillBar();
            supBar1.fillBar();
            if (h==0&&turn>4){
                if (turn%4==1){
                    selColor(ind,h);
                }
                D1.setText(field.get(0).getDesc(ind-h*2+1));
                supBar1.setBorC(Color.black);
                supBar2.setBorC(Color.black);
                supBar3.setBorC(Color.black);
                supBar4.setBorC(Color.black);
            }
            else if (h==1&&turn>4){
                if (turn%4==2){
                    selColor(ind,h);
                }
                D2.setText(field.get(0).getDesc(ind-h*2+1));
                supBar1.setBorC(Color.black);
                supBar2.setBorC(Color.black);
                supBar3.setBorC(Color.black);
                supBar4.setBorC(Color.black);
            }
            else if (h==2&&turn>4){
                if (turn%4==3){
                    selColor(ind,h);
                }
                D3.setText(field.get(0).getDesc(ind-h*2+1));
                supBar1.setBorC(Color.black);
                supBar2.setBorC(Color.black);
                supBar3.setBorC(Color.black);
                supBar4.setBorC(Color.black);
            }
            else if (h==3&&turn>4){
                if (turn%4==0){
                    selColor(ind,h);
                }
                D4.setText(field.get(0).getDesc(ind-h*2+1));
                supBar1.setBorC(Color.black);
                supBar2.setBorC(Color.black);
                supBar3.setBorC(Color.black);
                supBar4.setBorC(Color.black);
            }
            else{
                selected = prevSel;
            }            
        }
        public void addConfirm(int ind, int h){
            int type = ind-h*2+1;
            Border border = new LineBorder(new Color(139, 0, 0),3,true);
            // index/2 is one less than card number. Ex) index 0 and 1 are card 1.
            if (h==0&&!confirms.containsKey(1)){
                //Key number is the card number
                confirms.put(1,new JButton("Confirm"));
                a1.add(confirms.get(1));
                confirms.get(1).setBackground(Color.darkGray);
                confirms.get(1).setFont(new Font("Comic Sans MS", Font.BOLD, 48));
                confirms.get(1).setForeground(Color.green);
                confirms.get(1).setBorder(border);
                confirms.get(1).addActionListener(new Confirms(1,type));
            }
            else if (h==1&&!confirms.containsKey(2)){
                confirms.put(2,new JButton("Confirm"));
                a2.add(confirms.get(2));
                confirms.get(2).setBackground(Color.darkGray);
                confirms.get(2).setFont(new Font("Comic Sans MS", Font.BOLD, 48));
                confirms.get(2).setForeground(Color.green);
                confirms.get(2).setBorder(border);
                confirms.get(2).addActionListener(new Confirms(2,type));
            }
            else if (h==2&&!confirms.containsKey(3)){
                confirms.put(3,new JButton("Confirm"));
                a3.add(confirms.get(3));
                confirms.get(3).setBackground(Color.darkGray);
                confirms.get(3).setFont(new Font("Comic Sans MS", Font.BOLD, 48));
                confirms.get(3).setForeground(Color.green);
                confirms.get(3).setBorder(border);
                confirms.get(3).addActionListener(new Confirms(3,type));
    
            }
            else if (h==3&&!confirms.containsKey(4)){
                confirms.put(4,new JButton("Confirm"));
                a4.add(confirms.get(4));
                confirms.get(4).setBackground(Color.darkGray);
                confirms.get(4).setFont(new Font("Comic Sans MS", Font.BOLD, 48));
                confirms.get(4).setForeground(Color.green);
                confirms.get(4).setBorder(border);
                confirms.get(4).addActionListener(new Confirms(4,type));
            }
            else{
                ((Confirms)confirms.get(h+1).getActionListeners()[0]).setTy(type);
            }
            prevSel = selected;
            revalidate();
            repaint();
        }
        class superCharge extends JPanel{
            private ArrayList<JPanel> panels = new ArrayList<>();
            private int barCount = 0;
            private int maxBars;
            private String text="";
            private int cNum;
            superCharge(int ba, int num){
                super();
                maxBars = ba;
                cNum = num;
                setLayout(new GridLayout(1,3));
                Border border = new LineBorder(Color.black,3,true);
                setBorder(border);
                setPreferredSize(new Dimension(50,50));
                
                for (int i=0; i<ba; i++){
                    panels.add(new JPanel());
                    panels.get(i).setBackground(Color.white);
                    add(panels.get(i));
                }
    
                addMouseListener(new click());
            }
    
            public void setBorC(Color c){
                Border border = new LineBorder(c,3,true);
                setBorder(border);
            }
    
            public void setMB(int ba){
                for (int i=maxBars-1; i>=0; i--){
                    remove(panels.remove(i));
                }
                maxBars = ba;
                setLayout(new GridLayout(1,maxBars));
                for (int i=0; i<maxBars; i++){
                    panels.add(new JPanel());
                    panels.get(i).setBackground(Color.white);
                    add(panels.get(i));
                }
            }
    
            public void fillBar(){
                if (barCount==maxBars-1){
                    for (int i=0; i<barCount+1; i++){
                        panels.get(i).setBackground(Color.red);
                    }
                }
                else if (barCount<maxBars){
                    for (int i=0; i<barCount+1; i++){
                        panels.get(i).setBackground(Color.orange);
                    }
                }
                //barCount==maxBars
                else{
                    barCount--;
                }
                barCount++;
                revalidate();
                repaint();
            }
    
            public void useBar(int type){
                //change out numbers in accordance to risky code
                if (type==1){ 
                    if (barCount==0){
                    }
                    else{
                        System.out.println(maxBars-1);
                        System.out.println(barCount-2);
                        for (int i = maxBars-1; i>barCount-2; i--){
                            panels.get(i).setBackground(Color.white);
                        }
                        for (int i=0; i<barCount-1; i++){
                            panels.get(i).setBackground(Color.orange);
                        }
                        barCount--;
                    }
                    
                }
                else if (type==2){
                    System.out.println("hi");
                    if (barCount==maxBars){
                        System.out.println("wowo");
                        for (int i=0; i<maxBars; i++){
                            panels.get(i).setBackground(Color.white);
                            System.out.println("gaa");
                        }
                        System.out.println("wowo");
                        barCount=0;
                        //add code for the super function
                    }
                }
                System.out.println(type);
                revalidate();
                repaint();
            }
    
            public void setT(String ta){
                text = ta;
            }
    
            class click extends MouseAdapter{
                Border border = new LineBorder(Color.blue,3,true);
                public void mousePressed(MouseEvent m) {
                    if (cNum==1){
                        D1.setText(text);
                    }
                    else if (cNum==2){
                        D2.setText(text);
                    }
                    else if (cNum==3){
                        D3.setText(text);
                    }
                    else if (cNum==4){
                        D4.setText(text);
                    }
                    if ((cNum==turn%4||cNum==turn%4+4)&&turn>4){
                        if (barCount==maxBars){
                            setBorC(Color.green);
                            if (prevSel!=null){
                                atks.get(atks.indexOf(prevSel)).setBackground(Color.white);
                            }
                            selected = null;
                            //sup Num doesn't matter
                            addConfirm(cNum,3,1);
                        }
                    }
                }
            }
    }*/
}
