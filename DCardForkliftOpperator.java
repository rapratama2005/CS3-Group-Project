//R 4/11: Forklift Opperator - Support-DPS hybrid
public class DCardForkliftOpperator extends DsuperCard{
    String initName = "Forklift Opperator";
    int initHP = 19;
    int initAtk = 3;
    int initSup = 9;
    int initB = 4;
    String[] moveSet = {"Ramming Forks","Safety Requirments", "Heavy Lifting"};
    int[] applicability = {1, 2, 0};//0 is self, 1 is enemy, 2 is ally, 3 is ally and self
    String image = "ICards/ForkliftOpperator.png";
    String[] desc = {
        "What matters is that I'm forklift certified, and you're not", 
        "Strong but slow. Deals base damage.", 
        "Safety Always comes first. Grants self and one ally a magnitude 2 resistance effect for duration 3.", 
        "Steady... Steady... Grants self a magnitude 4 duration 2 strength effect."
    };

    public DCardForkliftOpperator() {
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 6, 1, 1, 1, 2, "Ivy.jpg");
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
        super.setDesc(desc);
        super.setApplicabilityArray(applicability);
    }

    @Override
    public String atk(DsuperCard target) {
        /*
         * Attack Desc
         * 
         */
        target.hurt(super.getAtk());
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * 
         */
        if (!super.checkB()){
            return(super.bAtk(target));
        } else {
            DConditionResistance s = new DConditionResistance(3, "Safety Requirments", 2);
            inflictCondition(target, s);
            inflictCondition(this, s);
            return(super.bAtk(target));
        }
    }

    @Override
    public String sAtk(DsuperCard target) {
        /*
         * S Attack Desc
         * 
         */
        if (!super.checkSup()){
            return(super.sAtk(target));
        } else {
            DConditionStrength s = new DConditionStrength(2, "Heavy Lifting", 4);
            inflictCondition(target, s);
            return(super.sAtk(target));
        }
    }
    
}
