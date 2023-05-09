import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GSelectionScreen extends JFrame{
    int perSide = 2;
    int totalCards = perSide*2;
    DsuperCard[] sideA = new DsuperCard[perSide];
    DsuperCard[] sideB = new DsuperCard[perSide];
    Color colorA = Color.red;
    Color colorB = Color.blue;
    DDeck drawFrom = new DDeck();
    DDeck cardIDs = new DDeck();
    int selectable = 0;

    public class Selection extends GPanel{
        private JComboBox box = new JComboBox();
        private GPanel pan = new GPanel(WIDTH, HEIGHT, 2, 1, Color.white);
        GPanel imgPlace = new GPanel(WIDTH,HEIGHT,1,1,Color.white);
        private ImageIcon a = null;
        private JLabel pic;
        //TODO add image logic for this box
        private JTextArea tex = new JTextArea(10,15);
        int slot;
        boolean aNotB;
        DDeck deck = new DDeck();


        Selection(int s, boolean r) {
            super(WIDTH, HEIGHT, 2, 1, Color.white);
            slot = s;
            aNotB = r;
            //add cards from deck to JComboBox
            if(selectable==0){
                selectable=deck.getDeck().size();
            }
            for (int i = 0; i < selectable; i++){
                String drawn = deck.draw().getName();
                box.addItem(drawn);
                if(i==0){
                    if(aNotB){
                        sideA[slot] = cardIDs.cardID(drawn);
                        a = new ImageIcon(sideA[slot].getImgSource());
                    } else {
                        sideB[slot] = cardIDs.cardID(drawn);
                        a = new ImageIcon(sideB[slot].getImgSource());
                    }
                }
            }
            box.addActionListener(new boxes());
            pan.add(box);

            tex.setEditable(false);
            tex.setLineWrap(true);
            tex.setWrapStyleWord(true);
            JScrollPane s1 = new JScrollPane(tex);

            pan.add(s1);

            pic = new JLabel(a);
            imgPlace.add(pic);
            add(imgPlace);
            add(pan);
        } 

        class boxes implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String)((JComboBox)e.getSource()).getSelectedItem();
                DsuperCard temp;
                if(aNotB){
                    sideA[slot] = cardIDs.cardID(selected);
                    a = new ImageIcon(sideA[slot].getImgSource());
                    temp = sideA[slot];
                } else {
                    sideB[slot] = cardIDs.cardID(selected);
                    a = new ImageIcon(sideB[slot].getImgSource());
                    temp = sideB[slot];
                }
                tex.setText(temp.getDesc(0));
                pic = new JLabel(a);
                imgPlace.removeAll();
                imgPlace.add(pic);
                printSelected();
                revalidate();
                repaint();
            }
            
        }

    }

    public class Confirm extends GPanel{
        JButton confirm = null;

        Confirm() {
            super(WIDTH, HEIGHT, 1, 1, Color.white);
            //TODO Auto-generated constructor stub
            confirm = new JButton("Confirm");
            confirm.setBackground(Color.gray);
            confirm.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            Border border = new LineBorder(Color.green,3,true);
            confirm.setForeground(Color.yellow);
            confirm.setBorder(border);
            add(confirm);
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
    

    GSelectionScreen(){
        super();
        setSize(new Dimension(1920, 1080/2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,totalCards+1));
        for(int i = 0; i < perSide; i++){
            Selection a = new Selection(i, true);
            add(new Selection(i, true));
        }
        Confirm c = new Confirm();
        add(c);
        for(int i = 0; i < perSide; i++){
            add(new Selection(i, false));
        }
        setVisible(true);
        c.confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                GBattleScreen3 g = new GBattleScreen3(sideA, sideB, colorA, colorB);
                setVisible(false);
            }
            
        });

        
    }
}
