import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk;
    private String name, atkName, supName, bName;
    private ArrayList<DCondition> cond = new ArrayList<DCondition>();
    private double boostHealth, boostAtk; //R 4/8: Added BoostHealth and BoostAtk, will be used for conditions  
    public DsuperCard(int mH,int mA,int H,int A,String na,String aN,String sN,String bN){
        maxHealth = mH; // R 4/11: What range of HP and ATK do we want? Proposal: 15 HP for tanks, 8-10 HP for DPS/Support, 5-4 ATK for DPS, 1-3 for Tank, 1-2 for Support
        maxAtk = mA;
        Health = H;
        atk = A;
        name = na;
        atkName = aN;
        supName = sN;
        bName = bN;

        // R 4/11: boosts should start at 1x and can be modified to 
        // R 4/11: do we want boosts as additive (+1, +2, -1) or multiplicative (/2, *2, *1.5)?
        boostHealth = 1.0;
        boostAtk = 1.0;
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
    public ArrayList<DCondition> getConditions(){
        return cond;
    }
    public double getBoostHealth(){
        return boostHealth;
    }
    public double getBoostAtk(){
        return boostAtk;
    }
    //Set functions
    public int setMaxH(int mH){
        maxHealth = mH;
        return maxHealth;
    }
    public int setMaxA(int mA){
        maxAtk = mA;
        return maxAtk;
    }
    public int setHealth(int H){
        Health = H;
        return Health;
    }
    public int setAtk(int A){
        atk = A;
        return atk;
    }
    public ArrayList<DCondition> addConditions(DCondition C){
        cond.add(C);
        return cond;
    }
    public double setBoostHealth(double bH){
        boostHealth=bH;
        return boostHealth;
    }
    public double setBoostAtk(double bAtk){
        boostAtk=bAtk;
        return boostAtk;
    }
    //Abstract Func
    public abstract void atk(DsuperCard target);
    public abstract void bAtk(DsuperCard target);
    public abstract void sAtk(DsuperCard target);
    //Essentials
    public int heal(int H){
        Health+=H;
        return Health;
    }
    public int hurt(int H){
        Health-=H;
        return Health;
    }
}
