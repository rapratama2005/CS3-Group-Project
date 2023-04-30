//Drunken Sailor - Tank card
public class DCardDrunkenSailor extends DsuperCard{
    String initName = "Drunken Sailor";
    int initHP = 18;
    int initAtk = 3;
    int initSup = 8;
    int initB = 5;
    String[] moveSet = {"Bottle","'Synchronized' Singing", "Alcoholic Resistance"};
    int[] applicability = {1, 1, 0};
    String image = "Ivy.jpg";
    String[] desc = {
        "What do we do with the Drunken Sailor?", 
        "A Simple Bottle Attack. Deals the base damage of " + initAtk + " on an enemy.", 
        "The... 'Quality' of the voice is effective in weakening your enemy for a period of time. Inflicts a weakness effect with a duration of 3 and a magnitude of 2.", 
        "Years of drinking have strengthened your resolve. Grants strength for a duration of 3 and a magnitude of 3."
    };

    public DCardDrunkenSailor() {
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
        super.setApplicabilityArray(applicability);
        super.setDesc(desc);
    }

    @Override
    public String atk(DsuperCard target) {
        /*
         * Attack Desc
         * Simple Bottle Attack
         */
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * Inflicts a weakness effect on enemy
         */
        if (!super.checkSup()){
            return(super.bAtk(target));
        } else {
            DCondition s = new DConditionWeakness(3, "'Synchronized' Singing", 2);
            target.addConditions(s);
            return(super.bAtk(target));
        }
    }

    @Override
    public String sAtk(DsuperCard target) {
        /*
         * S Attack Desc
         * Alcoholic Resistance - thanks to years of drinking, your body is now stronger
         */
        if (!super.checkSup()){
            return(super.sAtk(target));
        } else {
            DCondition s = new DConditionResistance(3, "Alcoholic Resistance", 3);
            target.addConditions(s);
            return(super.sAtk(target));
        }
    }
    
}
