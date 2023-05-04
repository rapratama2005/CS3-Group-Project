import java.awt.Color;

public class GCard extends GPanel{
    DsuperCard x; //0
    DsuperCard ally; //2
    DsuperCard[] enemy; //1
    DsuperCard[] allyAndSelf; //3
    GCard(boolean left) {
        super(WIDTH, HEIGHT / 2, 1, 2, Color.white);
        GCardSide1 atksSide = new GCardSide1();
        GCardSide2 descSide = new GCardSide2();
        if(left){
            add(atksSide);
            add(descSide);
        } else {
            add(descSide);
            add(atksSide);
        }
        //TODO Auto-generated constructor stub
    }

    DsuperCard setCard(DsuperCard y){
        x=y;
        return x;
    }

    DsuperCard getCard(){
        return x;
    }

    void updateCard(){

    }
    
}
