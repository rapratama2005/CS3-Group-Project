import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
public class GBattleScreen3 extends JFrame{
    String BattleLog = "";
    int round = 0;
    int turn = 0;
    public static void main(String args[]){
        GBattleScreen3 s = new GBattleScreen3();
    }

    GBattleScreen3(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        GCard r1 = new GCard(false, 0);
        GCard r2 = new GCard(false, 2);
        GCard b1 = new GCard(true, 1);
        GCard b2 = new GCard(true, 3);
        add(r1);
        add(b1);
        add(r2);
        add(b2);
        r1.onRound0();
        
        setVisible(true);
    }
}