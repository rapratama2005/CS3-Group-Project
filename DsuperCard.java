import java.io.File;
import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk,boostHealth, boostAtk, supReq, supProg; //R 4/8: Added BoostHealth and BoostAtk, will be used for conditions || R 4/15 Added supReq and supProg, will be used to determine when ultimate can be used
    private String name, atkName, supName, bName;
    //private File image;
    private ArrayList<DCondition> cond = new ArrayList<DCondition>();
    public DsuperCard(int mH,int mA,int H,int A,String na,String aN,String sN,String bN, int sR){
        maxHealth = mH;
        maxAtk = mA;
        Health = H;
        atk = A;
        name = na;
        atkName = aN;
        supName = sN;
        bName = bN;
        supReq = sR;
        supProg = 0;
        //image = new File(imgSource);
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
    public int getSupReq(){
        return supReq;
    }
    public int getSupProg(){
        return supProg;
    }
    /*
    //when ready
    public File getImage(){
        return image;
    }
    */
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
    public int setSupReq(int sR){
        supReq = sR;
        return supReq;
    }
    public int setSupProg(int sP){
        supProg = sP;
        return supProg;
    }
    //Abstract Func
    public String atk(DsuperCard target){

        return (this.getName() + " used " + this.getAName() + " (main attack) on " + target.getName() + ".");
    }
    public String bAtk(DsuperCard target){
        
        return (this.getName() + " used " + this.getBName() + " (main attack) on " + target.getName() + ".");
    }
    public String sAtk(DsuperCard target){
        if (!checkSup()){
            return this.name + " invalid use " + this.supName + " (special attack) on " + target.name;
        } else {
            supProg = 0;
        return this.name + " used " + this.supName + " (special attack) on " + target.name;
        }
    }
    //Essentials
    public int heal(int H){
        Health+=H;
        return Health;
    }

    public int hurt(int H){
        Health-=H;
        return Health;
    }

    public int sup(int P){
        supProg+=P;
        return supProg;
    }

    public boolean checkSup(){
        return(supProg>=supReq);
    }

    public int progSup(int pS){
        supProg += pS;
        return supProg;
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

    public boolean isDead(){ //R 4/15: May be necessary 
        return (Health<=0);
    }

    //To Str ing for Test ing
    public String toString(){
        String string = "";
        string += "Name: " + name + "\n";
        string += "Health: " + getHealth() + "/" + getMaxH() + "\n";
        string += "Dead: " + isDead() + "\n";
        string += "Condtions: " + cond.toString();
        return string;
    }
}
