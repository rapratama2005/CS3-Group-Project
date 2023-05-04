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
    private superCharge superbar = new superCharge(3, 1);
    private JPanel stats = new JPanel();
    private JButton prev;


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
        atk.addActionListener(new act(1));
        add(atk);
        batk = new JButton("B attack");
        batk.setBackground(Color.white);
        add(batk);
        batk.addActionListener(new act(2));
        
        add(superbar);
    }
   
    class act implements ActionListener{
        private int t;
        public act(int type){
            t=type;
        }
        public int getT(){
            return t;
        }
        public void actionPerformed(ActionEvent e){
            JButton selected = (JButton)e.getSource();
            ((JButton)e.getSource()).setBackground(Color.green);
            if (prev!=null&&prev!=selected){
                if (prev==atk){
                    atk.setBackground(Color.white);
                }
                else{
                    batk.setBackground(Color.white);
                }
            }
            prev = selected;
            addConfirm(t);
            //needs to change description
        }
    }
    public void addConfirm(int type){
        Border border = new LineBorder(new Color(139, 0, 0),3,true);
        // index/2 is one less than card number. Ex) index 0 and 1 are card 1.
        if (confirm==null){
            confirm = new JButton("Confirm");
            confirm.setBackground(Color.darkGray);
            confirm.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            confirm.setForeground(Color.green);
            confirm.setBorder(border);
            confirm.addActionListener(new confirms(type));
            add(confirm);
        }
        else{
            ((confirms)confirm.getActionListeners()[0]).setTy(type);
        }
        revalidate();
        repaint();
    }
    class confirms implements ActionListener{
        private int t;
        public confirms(int type){
            t = type;
        }
        public void setTy(int ty){
            t=ty;
        }
        //Attack and super functions
        public void actionPerformed(ActionEvent e){
            remove(confirm);
            if (t==1){
                superbar.fillBar();
                System.out.println("1");
            }
            else if (t==2){
                superbar.useBar(1);
                System.out.println("2");
            }
            else if (t==3){
                superbar.useBar(2);
                System.out.println("3");
            }
            confirm = null;
            revalidate();
            repaint();
        }
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
                //setText
                if (barCount==maxBars){
                    setBorC(Color.green);
                    atk.setBackground(Color.white);
                    batk.setBackground(Color.white);
                    //sup Num doesn't matter
                    addConfirm(3);
                }
            }
    }
}
}

