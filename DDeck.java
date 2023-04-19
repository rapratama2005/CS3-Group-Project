
import java.util.*;

public class DDeck {
    ArrayList<DsuperCard> deck = new ArrayList();
    DSampleCard sample1 = new DSampleCard();
    DSampleCard2 sample2 = new DSampleCard2();
    public DDeck (){
        deck.add(sample1);
        deck.add(sample2);
    }
    
    public DsuperCard draw(){
        return deck.remove(0);
    }
}
