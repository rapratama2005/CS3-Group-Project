import java.util.*;

//used for teams

//functions needed
/*
 * Auto Swap
 * Swap
 * Draw
 */


public class DAlliance {
    private HashMap<Integer, DsuperCard> field = new HashMap();
    private HashMap<Integer,DsuperCard> hand = new HashMap();
    private int fieldLimit = 2;
    private int handLimit = 4;
    private int swapsLeft = 2;
    private String name;

    public DAlliance (DDeck deck, String n){
        name = n;
        for (int i = 0; i < fieldLimit; i ++){
            field.put(i,deck.draw());
        }
        for (int i = 0; i < handLimit; i ++){
            hand.put(i,deck.draw());
        }
    }

    public String swap (int f, int h){
        if (swapsLeft <= 0){
            return (name + " cannot swap");
        }
        DsuperCard toField = hand.get(h);
        DsuperCard toHand = field.get(f);
        hand.remove(h);
        field.remove(f);
        hand.put(h, toHand);
        field.put(f, toField);
        swapsLeft-=1;
        return (name + " sent " + toField.getName() + " into the field and " + toHand.getName() + " into the hand and has " + swapsLeft + "swap(s) left");
    }

}