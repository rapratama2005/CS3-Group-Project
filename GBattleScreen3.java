import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.EncodedKeySpec;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class GBattleScreen3 extends JFrame{
    String BattleLog = "";
    int round = 0;
    int turn = 0;
    boolean currentSideA = true;
    int perSide;
    int totalCards;
    int desiredAction;
    int target;
    boolean targetSideA = false;
    DDeck drawFrom = new DDeck();
    DDeck cardIDs = new DDeck();
    DsuperCard[] sideA;
    DsuperCard[] sideB;
    GCard2[] cardList;
    Color colorA;
    Color colorB;

    public class GLabel extends JLabel{
        GLabel(String text){
            super(text);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }
    }

    public class GSide extends GPanel{
        GSide(Color color, boolean aNotB) {
            super(WIDTH /3 , HEIGHT, perSide, 1, color);
        }
    }

    public class GMid extends GSide{
        GMid(){
            super(Color.white, false);
        }
    }

    public class GCard2 extends GPanel{
        GPanel imgPlace = new GPanel(WIDTH,HEIGHT,1,1,Color.white);
        GCardMid mid;
        GCardDescAndConf descAndConf = new GCardDescAndConf(Color.white);
        boolean aNotB;
        boolean isDead;
        int slot;
        Color c;
        GCard2(boolean aNB, int s) {
            super(WIDTH, HEIGHT / 2, 1, 3, Color.white);
            aNotB = aNB;
            slot = s;
            mid = new GCardMid(Color.white);
            if(aNotB){
                imgPlace.setBackground(colorA);
                add(imgPlace);
                add(mid);
                add(descAndConf);
                c = colorA;
            } else {
                imgPlace.setBackground(colorB);
                add(descAndConf);
                add(mid);
                add(imgPlace);
                c = colorB;
            }
            DsuperCard temp;
                if (aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
            ImageIcon a = new ImageIcon(temp.getImgSource());
            JLabel pic = new JLabel(a);
            imgPlace.add(pic);
            modCombo m = new modCombo();
            toNext n = new toNext();
            boxIndex b = new boxIndex();
            mid.atk.button.addActionListener(m);
            mid.batk.button.addActionListener(m);
            mid.satk.button.addActionListener(m);
            descAndConf.con.button.addActionListener(n);
            descAndConf.box.addActionListener(b);
            checkAllEnabled();
        }

        void checkAllEnabled(){
            mid.atk.checkEnabled();
            mid.batk.checkEnabled();
            mid.satk.checkEnabled();
            descAndConf.con.checkEnabled();
            DsuperCard temp;
                if (aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
            mid.hpAndAtk.setText("HP: " + temp.getHealth() + "/" + temp.getMaxH() + " | ATK: " + temp.getAtk());
            mid.tempChargeBar.setText("CHARGE: " + temp.getSupProg() + "/" + temp.getBReq() + "/" + temp.getSupReq());
            
        }

        public class modCombo implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DsuperCard temp;
                int applyTo = -1;
                if(aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
                System.out.println(e.getSource());
                System.out.println(temp.getName() + temp.getAtkApplicability());
                if(e.getSource().equals(mid.atk.button)){
                    descAndConf.tex.setText(temp.getDesc(1));
                    applyTo=temp.getAtkApplicability();
                    desiredAction=1;

                } else if (e.getSource().equals(mid.batk.button)){
                    descAndConf.tex.setText(temp.getDesc(2));
                    mid.batk.checkEnabled();
                    if(mid.batk.enabled){
                        applyTo=temp.getBAtkApplicability();
                        desiredAction=2;
                    }
                } else if (e.getSource().equals(mid.satk.button)){
                    descAndConf.tex.setText(temp.getDesc(3));
                    mid.satk.checkEnabled();
                    if(mid.satk.enabled){
                        applyTo=temp.getSAtkApplicability();
                        desiredAction=3;
                    }
                }
                descAndConf.box.removeAllItems();
                ArrayList<String> x = new ArrayList<>();
                if(applyTo == -1){

                } if (applyTo == 0){
                    x.add(temp.getName());
                } else if (applyTo == 1){
                    if(aNotB){
                        for(DsuperCard i: sideB){
                            x.add(i.getName());
                        }
                    } else {
                        for(DsuperCard i: sideA){
                            x.add(i.getName());
                        } 
                    }
                } else if (applyTo == 2){
                    if(!aNotB){
                        for(int i = 0; i < sideB.length; i++){
                            if(i!=slot){
                                x.add(sideB[i].getName());
                            }
                        }
                    } else {
                        for(int i = 0; i < sideA.length; i++){
                            if(i!=slot){
                                x.add(sideA[i].getName());
                            }
                        }
                    }
                } else if (applyTo == 3){
                    if(!aNotB){
                        for(DsuperCard i: sideB){
                            x.add(i.getName());
                        }
                    } else {
                        for(DsuperCard i: sideA){
                            x.add(i.getName());
                        } 
                    }
                }
                System.out.println(""+applyTo+x);
                for(String i:x){
                    descAndConf.box.addItem(i);
                }
                revalidate();
                repaint();
            }
            
        }

        public class toNext implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource().equals(descAndConf.con.button)&&descAndConf.con.enabled){
                    if(desiredAction==0){

                    } if(desiredAction==1){
                        if(currentSideA){
                            BattleLog += sideA[turn].atk(sideB[target]);
                        } else {
                            BattleLog += sideB[turn].atk(sideA[target]);
                        }
                    } if(desiredAction==2){
                        if(currentSideA){
                            if(sideA[turn].getBAtkApplicability()==1){
                                BattleLog += sideA[turn].bAtk(sideB[target]) + "\n";
                            } else {
                                BattleLog += sideA[turn].bAtk(sideA[target]) + "\n";

                            }
                        } else {
                            if(sideB[turn].getBAtkApplicability()==1){
                                BattleLog += sideB[turn].bAtk(sideA[target]) + "\n";
                            } else {
                                BattleLog += sideB[turn].bAtk(sideB[target]) + "\n";

                            }
                        }
                    } if(desiredAction==3){
                        if(currentSideA){
                            if(sideA[turn].getSAtkApplicability()==1){
                                BattleLog += sideA[turn].sAtk(sideB[target])+ "\n";
                            } else {
                                BattleLog += sideA[turn].sAtk(sideA[target])+ "\n";

                            }
                        } else {
                            if(sideB[turn].getSAtkApplicability()==1){
                                BattleLog += sideB[turn].sAtk(sideA[target])+ "\n";
                            } else {
                                BattleLog += sideB[turn].sAtk(sideB[target])+ "\n";

                            }
                        }
                    }
                    
                    if(currentSideA){
                        currentSideA = false;
                    } else {
                        turn++;
                        currentSideA = true;
                    }
                    if(turn>=perSide){
                        turn=0;
                    }
                    System.out.println(""+turn+currentSideA);
                    
                    revalidate();
                    repaint();

                    for (int i = 0; i < cardList.length; i++){
                        cardList[i].checkAllEnabled();
                    }

                    System.out.println(BattleLog);
                }
            }
            
        }

        public class boxIndex implements ActionListener{

            public void actionPerformed(ActionEvent e) {
                int index = ((JComboBox)e.getSource()).getSelectedIndex();
                target = index;
                System.out.println(target);
            }
        }

        public class GButton extends GPanel{
            JButton button = null;
            boolean enabled = false;
            Color enabledColor = Color.lightGray;
            Color disabledColor = Color.gray;
            GButton(String t){
                super(WIDTH, HEIGHT, 1, 1, Color.gray);
                button = new JButton(t);
                //style shit
                button.setBackground(disabledColor);
                button.setVisible(true);
                    //UI - UPDATE STYLE HERE
                //end style shit
                add(button);
            }
    
            boolean checkEnabled(){
                return enabled;
            }
    
            void enabledDisabled(){
                if(enabled){
                    whenEnabled();
                } else {
                    whenDisabled();
                }
            }
    
            void whenEnabled(){
                button.setBackground(enabledColor);
            }
    
            void whenDisabled(){
                button.setBackground(disabledColor);
            }
        }
    
        public class GButtonAtk extends GButton{
            GButtonAtk() {
                super("A");
                String t;
                if(aNotB){
                    t = sideA[slot].getAName();
                } else {
                    t = sideB[slot].getAName();
                }
                button.setText(t);
                //TODO Auto-generated constructor stub
            }
            boolean checkEnabled(){
                enabled = (turn == slot && currentSideA == aNotB && !isDead);
                enabledDisabled();
                return enabled;
            }
        }

        public class GButtonBAtk extends GButton{
            GButtonBAtk() {
                super("B");
                String t;
                if(aNotB){
                    t = sideA[slot].getBName();
                } else {
                    t = sideB[slot].getBName();
                }
                button.setText(t);
                //TODO Auto-generated constructor stub
            }
            boolean checkEnabled(){
                DsuperCard temp;
                if (aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
                enabled = (turn == slot && currentSideA == aNotB && !isDead && temp.canBAtk());
                enabledDisabled();
                return enabled;
            }
        }

        public class GButtonSAtk extends GButton{
            GButtonSAtk() {
                super("S");
                String t;
                if(aNotB){
                    t = sideA[slot].getSName();
                } else {
                    t = sideB[slot].getSName();
                }
                button.setText(t);
                //TODO Auto-generated constructor stub
            }
            boolean checkEnabled(){
                DsuperCard temp;
                if (aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
                enabled = (turn == slot && currentSideA==aNotB && !isDead && temp.canSAtk());
                enabledDisabled();
                return enabled;
            }
        }
    
        public class GButtonConfirm extends GButton{
            GButtonConfirm() {
                super("Confirm");
                //TODO Auto-generated constructor stub
            }
            boolean checkEnabled(){
                DsuperCard temp;
                enabled = ((turn == slot) && (currentSideA == aNotB));
                System.out.println(turn == slot);
                System.out.println(currentSideA == aNotB);
                enabledDisabled();
                //System.out.println(enabled);
                return enabled;
            }
        }

        public class GCardMid extends GPanel{
            GButtonAtk atk = new GButtonAtk();
            GButtonBAtk batk = new GButtonBAtk();
            GButtonSAtk satk = new GButtonSAtk();
            GLabel hpAndAtk = new GLabel("HP || ATK");
            GLabel tempChargeBar = new GLabel("a");//Replace with actual bar later
            GCardMid(Color color) {
                super(WIDTH, HEIGHT, 5, 1, color);
                DsuperCard temp;
                if (aNotB){
                    temp = sideA[slot];
                } else {
                    temp = sideB[slot];
                }
                hpAndAtk.setText("HP: " + temp.getHealth() + "/" + temp.getMaxH() + " | ATK: " + temp.getAtk());
                tempChargeBar.setText("CHARGE: " + temp.getSupProg() + "/" + temp.getBReq() + "/" + temp.getSupReq());
                add(hpAndAtk);
                add(atk);
                add(batk);
                add(satk);
                add(tempChargeBar);
            }
            
        }
        
        public class GCardDescAndConf extends GPanel{
            private JComboBox box = new JComboBox(); 
            GButtonConfirm con = new GButtonConfirm();
            private JTextArea tex = new JTextArea(10,15);

            GCardDescAndConf(Color color) {
                super(WIDTH, HEIGHT, 3, 1, color);
                add(box);
                add(con);
                con.checkEnabled();
                tex.setEditable(false);
                JScrollPane s1 = new JScrollPane(tex);

                add(s1);
                //TODO Auto-generated constructor stub
            }
        }
        
    }

    public String printSelected(){
        String a = "";
        for (DsuperCard x: sideA){
            a += x.getName() + " , ";
        }
        a+="\n";
        for (DsuperCard x: sideB){
            a += x.getName() + " , ";
        }
        a+="\n";
        System.out.println(a);
        return a;
    }

    GBattleScreen3(DsuperCard[] sA, DsuperCard[] sB, Color cA, Color cB){
        super();
        perSide = sA.length;
        totalCards = perSide*2;
        sideA = sA;
        sideB = sB;
        colorA = cA;
        colorB = cB;
        cardList = new GCard2[totalCards];
        setSize(new Dimension(1920, 1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));
        GSide AGSide = new GSide(colorA, true);
        GSide BGSide = new GSide(colorB, false);
        GMid mid = new GMid();
        add(AGSide);
        add(mid);
        add(BGSide);
        toNext2 tn2 = new toNext2();
        for (int i = 0; i < perSide; i++){
            GCard2 a = new GCard2(true, i);
            GCard2 b = new GCard2(false, i);
            // a.descAndConf.con.button.addActionListener(tn2);
            // b.descAndConf.con.button.addActionListener(tn2);
            AGSide.add(a);
            BGSide.add(b);
            cardList[i*2] = a;
            cardList[i*2+1] = b;
        }
        //Round 0
        


      
        setVisible(true);
    }

    public class toNext2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println(""+turn+currentSideA);
            for (int i = 0; i < cardList.length; i++){
                cardList[i].checkAllEnabled();
            }
            revalidate();
            repaint();
            
        }
        
    }
}

    