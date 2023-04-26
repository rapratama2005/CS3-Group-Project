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
    private HashMap<Integer, DsuperCard> hand = new HashMap();
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

    //get funcs
    public String getName(){
        return name;
    }
    public int getFieldLimit(){
        return fieldLimit;
    }
    public int getHandLimit(){
        return handLimit;
    }
    public DsuperCard getFromHand(int h){
        return hand.get(h);
    }
    public DsuperCard getFromField(int h){
        return field.get(h);
    }

    //set funcs
    public String setName(String n){
        name = n;
        return name;
    }
    public int setFieldLimit(int fL){
        fieldLimit = fL;
        return fieldLimit;
    }
    public int setHandLimit(int hL){
        handLimit = hL;
        return handLimit;
    }

    public String swap (int f, int h){
        // if (swapsLeft <= 0){
        //     return (name + " cannot swap " + f + " and " + h);
        // }
        if(hand.get(h).isDead()){
            return (name + " cannot swap " + hand.get(h).getName() + " and " + field.get(f).getName() + " (From Hand is Dead)\n");
        }
        DsuperCard toField = hand.get(h);
        DsuperCard toHand = field.get(f);
        hand.remove(h);
        field.remove(f);
        hand.put(h, toHand);
        field.put(f, toField);
        //swapsLeft-=1;
        return (name + " sent " + toField.getName() + " into the field and " + toHand.getName() + " into the hand\n");
    }

    public String forceSwapCheck(){
        String returnString = "";
        for (int i = 0; i < field.size(); i++){
            if (field.get(i).isDead()){
                for (int j = 0; j < hand.size(); j++){
                    if (!hand.get(j).isDead()){
                        returnString += swap(i, j);
                        break;
                    }
                }
            }
        }
        return returnString;
    }

}