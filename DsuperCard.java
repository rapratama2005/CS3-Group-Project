import java.io.File;
import java.util.*;
public abstract class DsuperCard {
    private int maxHealth,maxAtk,Health,atk,boostHealth, boostAtk, supReq, supProg, bReq; //R 4/8: Added BoostHealth and BoostAtk, will be used for conditions || R 4/15 Added supReq and supProg, will be used to determine when ultimate can be used
    private String name, atkName, supName, bName, imgSource;
    private int applyAtk, applyBAtk, applySAtk; //applicability of attacks: 0 is self, 1 is enemy, 2 is allies, 3 is allies and self
    private int[] applicabilityArray; //because we are forward thinking individuals
    //private File image;
    private ArrayList<DCondition> cond = new ArrayList<DCondition>();
    private String[] desc = new String[4];
    public DsuperCard(int mH,int mA,int H,int A,String na,String aN,String sN,String bN, int bR, int sR, int aA, int aB, int aS, String img){
        maxHealth = mH;
        maxAtk = mA;
        Health = H;
        atk = A;
        name = na;
        atkName = aN;
        supName = sN;
        bName = bN;
        supReq = sR;
        bReq = bR;
        applyAtk = aA;
        applyBAtk = aB; 
        applySAtk = aS;
        supProg = 0;
        boostHealth = 0;
        boostAtk = 0;
        imgSource = img;
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
        if (atk+boostAtk>0){
            return atk+boostAtk;
        } else {
            return 0;
        }
    }
    public int getRawAtk(){
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
    public int getBReq(){
        return bReq;
    }
    public int getSupReq(){
        return supReq;
    }
    public int getSupProg(){
        return supProg;
    }
    public int getBoostHealth(){
        int b = boostHealth;
        //boostHealth = 0;
        return b;
    }
    public int getBoostAtk(){
        int b = boostAtk;
        //boostAtk = 0;
        return b;
    }
    public String getImgSource(){
        return imgSource;
    }
    public int getAtkApplicability(){
        return applyAtk;
    }
    public int getBAtkApplicability(){
        return applyBAtk;
    }
    public int getSAtkApplicability(){
        return applySAtk;
    }
    public ArrayList<DCondition> getConditions(){
        return cond;
    }
    public int[] getApplicabilityArray(){
        return applicabilityArray;
    }
    public int getApplicability(int i){
        return applicabilityArray[i];
    }
    public String getDesc(int i){
        return desc[i];
    }
    public String[] getAllDesc(){
        return desc;
    }
    public boolean canBAtk(){
        return bReq <= supProg;
    }
    public boolean canSAtk(){
        return supReq <= supProg;
    }
    public boolean canBSatk(int i){
        if(i==0){
            return canBAtk();
        } else {
            return canSAtk();
        }
    }
    /*
    //when ready
    public Srting getImageSource(){
        return fileName;
    }
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
    public String setAName(String aN){
        atkName = aN;
        return atkName;
    }
    public String setSName(String sN){
        supName = sN;
        return supName;
    }
    public String setBName(String bN){
        bName = bN;
        return bName;
    }
    public ArrayList<DCondition> addConditions(DCondition C){
        C.setDuration(C.getDuration()+1);
        C.effect(this);
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
    public int setBReq(int bR){
        bReq = bR;
        return bReq;
    }
    public int setSupProg(int sP){
        supProg = sP;
        return supProg;
    }
    public String setImgSource(String i){
        imgSource = i;
        return imgSource;
    }
    public int setAtkApplicability(int aA){
        applyAtk=aA;
        return applyAtk;
    }
    public int setBAtkApplicability(int aB){
        applyBAtk = aB;
        return applyBAtk;
    }
    public int setSAtkApplicability(int aS){
        applySAtk = aS;
        return applySAtk;
    }
    public int[] setApplicabilityArray(int[] arr){
        applicabilityArray = arr;
        return applicabilityArray;
    }
    public String[] setDesc(String[] de){
        desc = de;
        return desc;
    }
    //Abstract Func
    public String atk(DsuperCard target){
        return (this.getName() + " used " + this.getAName() + " (main attack) on " + target.getName());
    }
    public String bAtk(DsuperCard target){
        if(!checkB()){
            return this.getName() + " invalid use " + this.getBName() + " (alternate attack) on " + target.getName();
        } else {
            supProg -= bReq;
            return (this.getName() + " used " + this.getBName() + " (alternate attack) on " + target.getName());
        }
    }
    public String sAtk(DsuperCard target){
        if (!checkSup()){
            return this.getName() + " invalid use " + this.getSName() + " (special attack) on " + target.getName();
        } else {
            supProg = 0;
            return this.getName() + " used " + this.getSName() + " (special attack) on " + target.getName();
        }
    }
    //Essentials
    public int heal(int H){
        Health+=H;
        return Health;
    }

    public int hurt(int H){
        H-=boostHealth;
        if(H>0){
            Health-=H;
        }
        return Health;
    }

    public int sup(int P){
        supProg+=P;
        return supProg;
    }

    public boolean checkSup(){
        return(supProg>=supReq);
    }

    public boolean checkB(){
        return(supProg>=bReq);
    }

    public int progSup(int pS){
        if(pS==0){
            pS=1;
        }
        supProg += pS;
        return supProg;
    }
    
    public ArrayList<DCondition> checkConditions(){
        //R 4/19: resets boosts so that conditions can take effect
        boostHealth = 0;
        boostAtk = 0;
        for (int i = 0; i < cond.size(); i++){
            cond.get(i).effect(this);
            if(cond.get(i).getDuration()<=0){
                cond.remove(i);
                i--;
            }
        }
        return cond;
    }

    public DCondition inflictCondition(DsuperCard target, DCondition c){
        c.setDuration(c.getDuration()+1);
        c.effect(target);
        target.addConditions(c);
        return c;
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
        string += "Condtions: " + cond.toString() + "\n";
        string += "Ultimate Progress: " + supProg + "/" + supReq + "\n";
        return string;
    }
}
