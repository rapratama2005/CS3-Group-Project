import DConditionResistance;
import DsuperCard;

package ScrappedCards;
//R 4/11: Sample Card to test
//Turbonerd (Ken)
//Tank
//Math: Random Number Attack
//Resistance: Reduces Damage of Incoming Attacks
//Quadratic Equation: Super Resistance for 1 turn + heals himself 5
public class DCardTurbonerd extends DsuperCard{
    String initName = "TurboNerd";
    int initHP = 20;
    int initAtk = 2;
    int initSup = 10;
    int initB = 2;
    String[] moveSet = {"Math","Resistance", "Quadratic Equation"};
    int[] applicability = {1, 0, 0};
    String image = "Ivy.jpg";

    public DCardTurbonerd() {
        //super constructor is placeholder
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 6, 1, 1, 1, 1, "Ivy.jpg");
        super.setName(initName);
        super.setHealth(initHP);
        super.setMaxH(initHP);
        super.setAtk(initAtk);
        super.setMaxA(initAtk);
        super.setAName(moveSet[0]);
        super.setBName(moveSet[1]);
        super.setSName(moveSet[2]);
        super.setSupReq(initSup);
        super.setBReq(initB);
        super.setImgSource(image);
        super.setAtkApplicability(applicability[0]);
        super.setBAtkApplicability(applicability[1]);
        super.setSAtkApplicability(applicability[2]);
    }

    @Override
    public String atk(DsuperCard target) {
        int a = (int) (Math.random()*5)+(getAtk()/2);
        target.hurt(a);
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        if (!super.checkSup()){
            return(super.bAtk(target));
        } else {
            DConditionResistance DConditionResistance = new DConditionResistance(3, "Resistance", 2);
            target.addConditions(DConditionResistance);
            return(super.bAtk(target));
        }
    }

    @Override
    public String sAtk(DsuperCard target) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'sAtk'");
        if (!super.checkSup()){
            return(super.sAtk(target));
        } else {
            DConditionResistance DConditionResistance = new DConditionResistance(1, "Resistance", 5);
            target.addConditions(DConditionResistance);
            target.heal(5);
            return(super.sAtk(target));
        }
    }
    
}
