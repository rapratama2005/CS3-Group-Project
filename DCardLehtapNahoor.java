//R 4/11: Sample Card to test //Attack
public class DCardLehtapNahoor extends DsuperCard{
    String initName = "LehtapNahoor";
    int initHP = 10;
    int initAtk = 4;
    int initSup = 16;
    int initB = 4;
    String[] moveSet = {"AI","Stumble Guys", "WHHAAATTTT"};
    int[] applicability = {1, 1, 0};
    String image = "Ivy.jpg";
    String[] desc = {
        "The most op card", 
        "Uses the power of AI. Deals base damage", 
        "Lags the opponent. Grants a weakness effect of magnitude 2 for 2 turns", 
        "Uses the power of his voice to reduce all incoming damage. Grants a resistance effect of magnitude 3 for 3 turns. Then increases attack by 2 for 3 turns"
    };

    public DCardLehtapNahoor() {
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
            target.addConditions(new DConditionWeakness(2, "Stumble Guys", 2));
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
            target.addConditions(new DConditionStrength(2, "WHHAAATTTT", 3));
            target.addConditions(new DConditionResistance(3, "WHHAAATTTT", 3));
            return(super.sAtk(target));
        }
    }
    
}
