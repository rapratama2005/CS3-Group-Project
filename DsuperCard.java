import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk,boostHealth, boostAtk; //R 4/8: Added BoostHealth and BoostAtk, will be used for conditions  
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
    public abstract void atk();
    public abstract void bAtk();
    public abstract void sAtk();
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
        string += "Condtions: " + cond.toString();
        return string;
    }
}
