package Unused;
import java.awt.Color;

import javax.swing.JLabel;

import GPanel;

public class GCardStats extends GPanel{
    String name;
    int val;
    JLabel nameL = new JLabel();
    JLabel valL = new JLabel();
    GCardStats(String n, int v) {
        super(WIDTH, HEIGHT, 1, 2, Color.white);
        name = n;
        val = v;
        nameL.setText(name);
        nameL.setVisible(true);
        nameL.setBackground(Color.BLACK);
        valL.setText(""+val);
        valL.setVisible(true);
        
    }

    void refreshVal(int v){
        val = v;
        valL.setText(""+val);
        valL.setVisible(true);

    }
    
}
