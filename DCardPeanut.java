//R 4/11: Peanut - DPS
public class DCardPeanut extends DsuperCard{
    String initName = "The Peanut";
    int initHP = 8;
    int initAtk = 4;
    int initSup = 15;
    int initB = 6;
    String[] moveSet = {"Tap","Blink", "Neck Snap!"};
    int[] applicability = {1, 1, 1};
    String image = "Ivy.jpg";
    String[] desc = {"173", "Atk Desc", "B Atk Desc", "S Atk Desc"};

    public DCardPeanut() {
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
         * Tap on the shoulder
         */
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * 
         */
        if (!super.checkSup()){
            return(super.bAtk(target));
        } else {
            DCondition s = new DConditionWeakness(3, "Blink", 2);
            target.addConditions(s);
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
            target.hurt(super.getAtk()*3);
            return(super.sAtk(target));
        }
    }
    
}
