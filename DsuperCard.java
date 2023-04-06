import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk;
    private String name, atkName, supName, bName;
    private ArrayList<DCondition> cond = new ArrayList<DCondition>();
    public DsuperCard(int mH,int mA,int H,int A,String na,String aN,String sN,String bN){
        maxHealth = mH;
        maxAtk = mA;
        Health = H;
        atk = A;
        name = na;
        atkName = aN;
        supName = sN;
        bName = bN;
    }
    //Get functions
    public int getMaxH(){
        return maxHealth;
    }
    public int getMaxA(){
        return maxAtk;
    }
    public int getHealth(){
        return Health;
    }
    public int getAtk(){
        return atk;
    }
    public String getName(){
        return name;
    }
    public String getAName(){
        return atkName;
    }
    public String getSName(){
        return supName;
    }
    public String getBName(){
        return bName;
    }
    //Abstract Func
    public abstract void atk();
    public abstract void bAtk();
    public abstract void sAtk();
}
