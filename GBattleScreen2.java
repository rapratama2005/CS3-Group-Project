import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.border.*;
import javax.swing.event.*;
// Dropdown box chooses card. It will give a description of the card and what it's attacks do
// Confirm button changes all of the graphics, removes the dropdown and confirm button and 
// add in the picture.
// at the end of every turn, the descriptions are reset.
// Pop up- how to do?
// use a count method to determine which turn it is and which buttons work and do not work
//Might use map of String card name, Card card; for the selection method
//Add a border and more space for each card
//change button backgrounds
// we need a dropdown box for choosing the cards.
// need a log that keeps track of the stats of all of the cards and what the cards are.
//Line 139 is where we might need to change because atm, we are allowing there to be multiple confirm buttons which is not what we want
//Change image section needs to be altered once we can get risky to change up the card classes.
//Giving players a hand is a lot to code so we are most likely not going to do that
//right side buttons need to be formatted
//change fill bar and use bar function colors
//bAttacks need to be disabled or colored black if there is no super charge
//super charge is ready and can be altered once we implement risky's code
//card classes need to have a function to change the description whenever you press a button so that user can read the card's effects
public class GBattleScreen2 extends JFrame{
    private JPanel card1,card2,card3,card4,hand1,hand2;
    //Picure and description sides
    private JPanel c1, c2, c3, c4;
    //picture JPanels
    private JPanel p1,p2,p3,p4;
    private JLabel card1P,card2P,card3P,card4P;
    private JTextArea D1,D2,D3,D4;
    private JComboBox box1, box2, box3, box4;
    //private DefaultListModel mod1, mod2, mod3, mod4;
    //private JList list1, list2, list3, list4;
    //Attack function sides
    private ArrayList<JLabel> currH = new ArrayList<JLabel>();
    private ArrayList<JLabel> currA = new ArrayList<JLabel>();
    //Current health and Current Atk are displayed
    private JPanel a1,a2,a3,a4;
    private superCharge supBar1,supBar2,supBar3,supBar4;
    private ArrayList<JButton> atks = new ArrayList<JButton>();
    private Map<Integer,JButton> confirms = new TreeMap<Integer,JButton>();
    private JButton at1,bat1,at2,bat2,at3,bat3,at4,bat4;
    private JButton selected;
    private JButton prevSel;
    // Cards
    private ArrayList<DsuperCard> field = new ArrayList<DsuperCard>();

    GBattleScreen2(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        
        card1 = new JPanel();
        card1.setLayout(new GridLayout(1,2));
        
        //right side
        a1 = new JPanel();
        a1.setLayout(new GridLayout(5,1));
        card1.add(a1);
        //Health and Attack
        JPanel cont1 = new JPanel();
        cont1.setLayout(new GridLayout(1,2));
        currH.add(new JLabel("H"));
        currA.add(new JLabel("A"));
        cont1.add(currH.get(0));
        cont1.add(currA.get(0));
        currH.get(0).setHorizontalAlignment(JLabel.LEFT);
        currH.get(0).setHorizontalTextPosition(JLabel.LEFT);
        currH.get(0).setVerticalAlignment(JLabel.TOP);
        currH.get(0).setVerticalTextPosition(JLabel.TOP);
        currA.get(0).setHorizontalAlignment(JLabel.RIGHT);
        currA.get(0).setHorizontalTextPosition(JLabel.RIGHT);
        currA.get(0).setVerticalAlignment(JLabel.TOP);
        currA.get(0).setVerticalTextPosition(JLabel.TOP);
        a1.add(cont1);

        atks.add(new JButton("attack"));
        a1.add(atks.get(0));
        atks.get(0).setBackground(Color.white);
        atks.get(0).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a1.add(atks.get(1));
        atks.get(1).setBackground(Color.white);
        atks.get(1).addActionListener(new act());
        supBar1 = new superCharge();
        a1.add(supBar1);
        //left side
        c1 = new JPanel();
        c1.setLayout(new GridLayout(2,1));
        card1.add(c1);

        p1 = new JPanel();
        card1P = new JLabel();
        box1 = new JComboBox();
        box1.addItem("Hi");
        box1.addItem("Wow");
        box1.addActionListener(new boxes());
        p1.add(box1);
        /*
        box = new JComboBox();
		ArrayList<String> chosen = new ArrayList<String>();
		for (String str: col.getColors()) {
			if(Math.random()>0.8) {
				chosen.add(str);
			}
		}
		for (int i=0; i<10; i++) {
			int index = (int)(Math.random()*chosen.size());
			box.addItem(chosen.remove(index));
		}
		box.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),100));
		add(box);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String color = (String)box.getSelectedItem();
		int[] rgb = col.getRGB(color);
		setBackground(new Color(rgb[0],rgb[1],rgb[2]));
	}*/
        p1.add(card1P);
        c1.add(p1);
        D1 = new JTextArea(10,15);
        D1.setEditable(false);
        JScrollPane s1 = new JScrollPane(D1);
        c1.add(s1);
        add(card1);


        card2 = new JPanel();
        card2.setLayout(new GridLayout(1,2));
        //left side
        c2 = new JPanel();
        c2.setLayout(new GridLayout(2,1));
        card2.add(c2);
        
        p2 = new JPanel();
        card2P = new JLabel();
        box2 = new JComboBox();
        box2.addItem("Hi");
        box2.addItem("Wow");
        box2.addActionListener(new boxes());
        p2.add(box2);
        p2.add(card2P);
        c2.add(p2);
        D2 = new JTextArea(10,15);
        D2.setEditable(false);
        JScrollPane s2 = new JScrollPane(D2);
        c2.add(s2);
        //right side
        a2 = new JPanel();
        a2.setLayout(new GridLayout(5,1));
        card2.add(a2);
        //Health and Attack
        JPanel cont2 = new JPanel();
        cont2.setLayout(new GridLayout(1,2));
        currH.add(new JLabel("H"));
        currA.add(new JLabel("A"));
        cont2.add(currH.get(1));
        cont2.add(currA.get(1));
        a2.add(cont2);
        currH.get(1).setHorizontalAlignment(JLabel.LEFT);
        currH.get(1).setHorizontalTextPosition(JLabel.LEFT);
        currH.get(1).setVerticalAlignment(JLabel.TOP);
        currH.get(1).setVerticalTextPosition(JLabel.TOP);
        currA.get(1).setHorizontalAlignment(JLabel.RIGHT);
        currA.get(1).setHorizontalTextPosition(JLabel.RIGHT);
        currA.get(1).setVerticalAlignment(JLabel.TOP);
        currA.get(1).setVerticalTextPosition(JLabel.TOP);

        atks.add(new JButton("attack"));
        a2.add(atks.get(2));
        atks.get(2).setBackground(Color.white);
        atks.get(2).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a2.add(atks.get(3));
        atks.get(3).setBackground(Color.white);
        atks.get(3).addActionListener(new act());
        supBar2 = new superCharge();
        a2.add(supBar2);
        add(card2);

        card3 = new JPanel();
        card3.setLayout(new GridLayout(1,2));
        //right side
        a3 = new JPanel();
        a3.setLayout(new GridLayout(5,1));
        card3.add(a3);
        //Health and Attack
        JPanel cont3 = new JPanel();
        cont3.setLayout(new GridLayout(1,2));
        currH.add(new JLabel("H"));
        currA.add(new JLabel("A"));
        cont3.add(currH.get(2));
        cont3.add(currA.get(2));
        a3.add(cont3);
        currH.get(2).setHorizontalAlignment(JLabel.LEFT);
        currH.get(2).setHorizontalTextPosition(JLabel.LEFT);
        currH.get(2).setVerticalAlignment(JLabel.TOP);
        currH.get(2).setVerticalTextPosition(JLabel.TOP);
        currA.get(2).setHorizontalAlignment(JLabel.RIGHT);
        currA.get(2).setHorizontalTextPosition(JLabel.RIGHT);
        currA.get(2).setVerticalAlignment(JLabel.TOP);
        currA.get(2).setVerticalTextPosition(JLabel.TOP);

        atks.add(new JButton("attack"));
        a3.add(atks.get(4));
        atks.get(4).setBackground(Color.white);
        atks.get(4).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a3.add(atks.get(5));
        atks.get(5).setBackground(Color.white);
        atks.get(5).addActionListener(new act());
        supBar3 = new superCharge();
        a3.add(supBar3);

        //left side
        c3 = new JPanel();
        c3.setLayout(new GridLayout(2,1));
        card3.add(c3);
        p3 = new JPanel();
        card3P = new JLabel();
        box3 = new JComboBox();
        box3.addItem("Hi");
        box3.addItem("Wow");
        box3.addActionListener(new boxes());
        p3.add(box3);
        p3.add(card3P);
        c3.add(p3);
        D3 = new JTextArea(10,15);
        D3.setEditable(false);
        JScrollPane s3 = new JScrollPane(D3);
        c3.add(s3);
        add(card3);
        
        card4 = new JPanel();
        card4.setLayout(new GridLayout(1,2));
        //left side
        c4 = new JPanel();
        c4.setLayout(new GridLayout(2,1));
        card4.add(c4);
        p4 = new JPanel();
        card4P = new JLabel();
        box4 = new JComboBox();
        box4.addItem("Hi");
        box4.addItem("Wow");
        box4.addActionListener(new boxes());
        p4.add(box4);
        p4.add(card4P);
        c4.add(p4);
        D4 = new JTextArea(10,15);
        D4.setEditable(false);
        JScrollPane s4 = new JScrollPane(D4);
        c4.add(s4);
        //right side
        a4 = new JPanel();
        a4.setLayout(new GridLayout(5,1));
        card4.add(a4);
        //Health and Attack
        JPanel cont4 = new JPanel();
        cont4.setLayout(new GridLayout(1,2));
        currH.add(new JLabel("H"));
        currA.add(new JLabel("A"));
        cont4.add(currH.get(3));
        cont4.add(currA.get(3));
        a4.add(cont4);
        currH.get(3).setHorizontalAlignment(JLabel.LEFT);
        currH.get(3).setHorizontalTextPosition(JLabel.LEFT);
        currH.get(3).setVerticalAlignment(JLabel.TOP);
        currH.get(3).setVerticalTextPosition(JLabel.TOP);
        currA.get(3).setHorizontalAlignment(JLabel.RIGHT);
        currA.get(3).setHorizontalTextPosition(JLabel.RIGHT);
        currA.get(3).setVerticalAlignment(JLabel.TOP);
        currA.get(3).setVerticalTextPosition(JLabel.TOP);

        atks.add(new JButton("attack"));
        a4.add(atks.get(6));
        atks.get(6).setBackground(Color.white);
        atks.get(6).addActionListener(new act());
        atks.add(new JButton("bAttack"));
        a4.add(atks.get(7));
        atks.get(7).setBackground(Color.white);
        atks.get(7).addActionListener(new act());
        supBar4 = new superCharge();
        a4.add(supBar4);
        add(card4);

        //Cards
        field.add(new DCardDrunkenSailor());
        field.add(new DCardMadScientist());
        field.add(new DCardDrunkenSailor());
        field.add(new DCardMadScientist());
        changeImage(2,field.get(0).getImgSource());
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
            // index/2 is one less than card number. Ex) index 0 and 1 are card 1.
            int h = ind/2;
            if (h==0&&!confirms.containsKey(1)){
                //Key number is the card number
                confirms.put(1,new JButton("Confirm"));
                a1.add(confirms.get(1));
                confirms.get(1).addActionListener(new Confirms(1));
                
            }
            else if (h==1&&!confirms.containsKey(2)){
                confirms.put(2,new JButton("Confirm"));
                a2.add(confirms.get(2));
                confirms.get(2).addActionListener(new Confirms(2));

            }
            else if (h==2&&!confirms.containsKey(3)){
                confirms.put(3,new JButton("Confirm"));
                a3.add(confirms.get(3));
                confirms.get(3).addActionListener(new Confirms(3));

            }
            else if (h==3&&!confirms.containsKey(4)){
                confirms.put(4,new JButton("Confirm"));
                a4.add(confirms.get(4));
                confirms.get(4).addActionListener(new Confirms(4));
            }
            prevSel = selected;
            revalidate();
            repaint();
        }
    }
    public void changeImage(int cardNum, String fileN){
        if (cardNum==1){
                p1.remove(card1P);
                ImageIcon a = new ImageIcon(fileN);
                card1P = new JLabel(a);
                p1.add(card1P);
            }
        else if (cardNum==2){
                p2.remove(card2P);
                ImageIcon a = new ImageIcon(fileN);
                card2P = new JLabel(a);
                p2.add(card2P);
            }
        else if (cardNum==3){
                p3.remove(card3P);
                ImageIcon a = new ImageIcon(fileN);
                card3P = new JLabel(a);
                p3.add(card3P);
            }
        else if (cardNum==4){
                p4.remove(card4P);
                ImageIcon a = new ImageIcon(fileN);
                card4P = new JLabel(a);
                p4.add(card4P);
            }
            revalidate();
            repaint();
        }

    class Confirms implements ActionListener{
        private int cardNum;
        public Confirms(int cardNum){
            this.cardNum = cardNum;
        }
        public void actionPerformed(ActionEvent e){
            changeImage(cardNum,"Ivy.jpg");
            if (cardNum==1){
                a1.remove(confirms.get(cardNum));
            }
            else if (cardNum==2){
                a2.remove(confirms.get(cardNum));
            }
            else if (cardNum==3){
                a3.remove(confirms.get(cardNum));
            }
            else if (cardNum==4){
                a4.remove(confirms.get(cardNum));
            }
            confirms.remove(cardNum);
            revalidate();
            repaint();
        }
    }

    class superCharge extends JPanel{
        private JPanel bar1,bar2,bar3;
        private int barCount = 0;
        superCharge(){
            super();
            setLayout(new GridLayout(1,3));
            Border border = new LineBorder(Color.black,3,true);
            setBorder(border);
            setPreferredSize(new Dimension(50,50));
            setBackground(Color.black);
            bar1 = new JPanel();
            bar1.setBackground(Color.white);
            add(bar1);

            bar2 = new JPanel();
            bar2.setBackground(Color.white);
            add(bar2);

            bar3 = new JPanel();
            bar3.setBackground(Color.white);
            add(bar3);
        }

        public void fillBar(){
            if (barCount==0){
                bar1.setBackground(Color.yellow);
            }
            else if (barCount==1){
                bar1.setBackground(Color.orange);
                bar2.setBackground(Color.orange);
            }
            else if (barCount==2){
                bar1.setBackground(Color.red);
                bar2.setBackground(Color.red);
                bar3.setBackground(Color.red);
            }
            //barCount==3
            else{
                barCount--;
            }
            barCount++;
            revalidate();
            repaint();
        }

        public void useBar(String type){
            if (type.equals("bAtk")){
                if (barCount==1){
                    bar1.setBackground(Color.white);
                }
                else if (barCount==2){
                    bar1.setBackground(Color.yellow);
                    bar2.setBackground(Color.white);
                }
                else if (barCount==3){
                    bar1.setBackground(Color.orange);
                    bar2.setBackground(Color.orange);
                    bar3.setBackground(Color.white);
                }
                //for barCount==0
                else{
                    barCount++;
                }
                barCount--;
            }
            else if (type.equals("super")){
                if (barCount==3){
                    bar1.setBackground(Color.white);
                    bar2.setBackground(Color.white);
                    bar3.setBackground(Color.white);
                    barCount=0;
                    //add code for the super function
                }
            }
            revalidate();
            repaint();
        }
    }

    class boxes implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String selected = (String)((JComboBox)e.getSource()).getSelectedItem();
            if (!confirms.containsKey(1)){
                confirms.put(1,new JButton("Confirm"));
                confirms.get(1).addActionListener(new confirmCard());
                p1.add(confirms.get(1));
            }
            D1.setText("Hello, we want you to choose this card to get the hello image. Cool wowo, blah blah filler filler");
        }
    }

    class confirmCard implements ActionListener{
        public void actionPerformed(ActionEvent e){
            p1.remove(confirms.get(1));
            confirms.remove(1);
            p1.remove(box1);
            D1.setText("");
            changeImage(1,"space.jpg");
        }
    }
    public static void main(String[] args){
        GBattleScreen2 running = new GBattleScreen2();
    }
}
