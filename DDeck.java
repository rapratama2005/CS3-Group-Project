import java.util.*;
import java.util.Collections;

public class DDeck {
    ArrayList<DsuperCard> deck = new ArrayList<>();
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
        Collections.shuffle(deck);
    }
    
    public DsuperCard draw(){
        return deck.remove(0);
    }
}
