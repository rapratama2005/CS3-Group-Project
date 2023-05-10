package Unused;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DsuperCard;
import GPanel;

public class GCard extends GPanel{
    DsuperCard x; //0
    DsuperCard ally; //2
    DsuperCard[] enemy; //1
    DsuperCard[] allyAndSelf; //3
    private int cardNum;
    int initative;
    ArrayList<DsuperCard> dropDownArrayList = new ArrayList<>();
    boolean isEnabled;
    GCardSide1 atksSide = new GCardSide1();
    GCardSide2 descSide = new GCardSide2();
    GCard(boolean left, int initative2, int c) {
        super(WIDTH, HEIGHT / 2, 1, 2, Color.white);
        initative = initative2;
        if(left){
            add(atksSide);
            add(descSide);
        } else {
            add(descSide);
            add(atksSide);
        }
        cardNum = c;
        //atksSide.setVisible(false);
        //descSide.setVisible(false);
        //TODO Auto-generated constructor stub

        ActionListener atk = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        };
    }

    void onRound0(){
        descSide.setVisible(true);
    }

    void onTurn(){
        isEnabled = true;
    }

    DsuperCard setCard(DsuperCard y){
        x=y;
        return x;
    }

    DsuperCard getCard(){
        return x;
    }

    int setInitiative(int x){
        initative = x;
        return initative;
    }

    void updateCard(){

    }
    
}
