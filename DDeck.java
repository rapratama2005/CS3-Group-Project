import java.util.*;

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
    }
    
    public DsuperCard draw(){
        return deck.remove(0);
    }
}
