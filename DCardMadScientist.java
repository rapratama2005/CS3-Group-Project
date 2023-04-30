//R 4/11: Mad Scientist Card - DPS
public class DCardMadScientist extends DsuperCard{
    String initName = "Mad Scientist";
    int initHP = 10;
    int initAtk = 5;
    int initSup = 15;
    int initB = 8;
    String[] moveSet = {"Laser Gun", "Funny Chemicals", "Mutantinator 9001"};
    int[] applicability = {1, 1, 0};
    String image = "Ivy.jpg";
    String[] desc = {
        "Don't let your lack of degree or ethics stop you from making scientific contributions", 
        "Pew Pew Pew! Deals base damage.", 
        "'I put colorful water into glass bottles!''why does this room smell weird'. Inflicts a random negative effect for a random duration and magnitude", 
        "'Behold, the Mutantinator 9001!'' Grants a magnitude 8 resistance and a magnitude 5 strength for a duration of 2, but at a cost of reducing health to 1."
    };

    public DCardMadScientist() {
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
         * Laser Gun
         */
        target.hurt(super.getAtk());
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * Inflicts a random, negative effect for random duration
         */
        if (!super.checkB()){
            return(super.bAtk(target));
        } else {
            DCondition s;
            int i = (int) Math.random()*4+2;
            int d = (int) Math.random()*4+2;
            int e = (int) Math.random()*2;
            if (e==0){
                s = new DConditionWeakness(i, "Funny Chemical (Weakness)", d);
            } else {
                s = new DConditionPoison(i, "Funny Chemical (Poison)", d);
            }
            inflictCondition(target, s);
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
            DCondition s = new DConditionResistance(3, "Mutant Resistance", 8);
            DCondition s2 = new DConditionStrength(3, "Mutant Strength", 5);
            target.setHealth(1);
            inflictCondition(target, s);
            inflictCondition(target, s2);
            return(super.sAtk(target));
        }
    }
    
}
