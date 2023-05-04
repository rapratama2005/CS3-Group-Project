import java.awt.Color;

public class GCardSide1 extends GPanel{
    GCardStats hp = new GCardStats("Health", 1);
    GCardStats at = new GCardStats("Base Attack", 1);
    GPanel hpAtk = new GPanel(WIDTH, HEIGHT, 1, 2, Color.white);

    GCardSide1() {
        super(WIDTH, HEIGHT, 5, 1, Color.white);
        hpAtk.add(hp);
        hpAtk.add(at);
        add(hpAtk);
    }
    
}
