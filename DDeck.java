import java.util.*;
import java.util.Collections;

public class DDeck {
    ArrayList<DsuperCard> deck = new ArrayList<>();
    TreeMap<String, DsuperCard> cardIDs = new TreeMap<>();
    DsuperCard DrunkenSailor = new DCardDrunkenSailor();
    DsuperCard MadScientist = new DCardMadScientist();
    DsuperCard MoralSupportWitch = new DCardMoralSupportWitch();
    DsuperCard Peanut = new DCardPeanut();
    DsuperCard PunchingBag = new DCardPunchingBag();
    public DDeck (){
        deck.add(DrunkenSailor);
        deck.add(MadScientist);
        deck.add(MoralSupportWitch);
        deck.add(Peanut);
        deck.add(PunchingBag);

        for(DsuperCard x: deck){
            cardIDs.put(x.getName(), x);
        }
    }
    
    public DsuperCard draw(){
        int r = (int) Math.random()*deck.size();
        return deck.remove(r);
    }

    public DsuperCard cardID (String i){
        return cardIDs.get(i);
    }

}
