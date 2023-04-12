import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk, supAtkProg, supAtkProgMax;
    private String name, atkName, supName, bName;
    private ArrayList<DCondition> cond = new ArrayList<DCondition>();
    private int boostHealth, boostAtk; //R 4/8: Added BoostHealth and BoostAtk, will be used for conditions  
    public DsuperCard(int mH,int mA,int H,int A,String na,String aN,String sN,String bN, int sM){
        maxHealth = mH; // R 4/11: What range of HP and ATK do we want? Proposal: 15 HP for tanks, 8-10 HP for DPS/Support, 5-4 ATK for DPS, 1-3 for Tank, 1-2 for Support
        maxAtk = mA;
        Health = H;
        atk = A;
        name = na;
        atkName = aN;
        supName = sN;
        bName = bN;
        supAtkProg = 0;
        supAtkProgMax = sM;

        // R 4/11: boosts should start at 1x and can be modified to 
        // R 4/11: do we want boosts as additive (+1, +2, -1) or multiplicative (/2, *2, *1.5)?
        boostHealth = 0;
        boostAtk = 0;
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
    public int getSupAtkProg(){
        return supAtkProg;
    }
    public int getSupAtkProgMax(){
        return supAtkProgMax;
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
    public int getBoostHealth(){
        return boostHealth;
    }
    public int getBoostAtk(){
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
    public int setSupAtkProg(int sA){
        supAtkProg = sA;
        return supAtkProg;
    }
    public int setSupAtkProgMax(int sM){
        supAtkProgMax = sM;
        return supAtkProgMax;
    }
    public String setName(String N){
        name = N;
        return name;
    }
    public ArrayList<DCondition> addConditions(DCondition C){
        cond.add(C);
        return cond;
    }
    public int setBoostHealth(int bH){
        boostHealth=bH;
        return boostHealth;
    }
    public int setBoostAtk(int bAtk){
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
    public ArrayList<DCondition> checkConditions(){
        for (int i = 0; i < cond.size(); i++){
            cond.get(i).effect(this);
            if(cond.get(i).getDuration()<=0){
                cond.remove(i);
                i--;
            }
        }
        return cond;
    }

    //To Str ing for Test ing
    public String toString(){
        String string = "";
        string += "Name: " + name + "\n";
        string += "Health: " + getHealth() + "/" + getMaxH() + "\n";
        string += "Condtions: " + cond.toString() + "\n";
        string += "Ultimate Progress: " + getSupAtkProg() + "/" + getSupAtkProgMax() + "\n";
        return string;
    }
}
