//R 4/11: Peanut - DPS
public class DCardPeanut extends DsuperCard{
    String initName = "The Peanut";
    int initHP = 8;
    int initAtk = 4;
    int initSup = 15;
    int initB = 6;
    String[] moveSet = {"Tap","Blink", "Neck Snap!"};
    int[] applicability = {1, 1, 1};
    String image = "ICards/Peanut.png";
    String[] desc = {
        "'Item SCP-173 is to be kept in a locked container at all times'-https://scp-wiki.wikidot.com/scp-173", 
        "Deals base damage.", 
        "'At all times, two persons must maintain direct eye contact with SCP-173 until all personnel have vacated and relocked the container.' Inflicts weakness effect of magnitude 1 duration 3 on an enemy", 
        "'Object is reported to attack by snapping the neck at the base of the skull, or by strangulation.' Inflicts 3x base damage on an enemy."
    };

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
            DCondition s = new DConditionWeakness(3, "Blink", 1);
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
