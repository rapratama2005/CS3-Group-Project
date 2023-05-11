//R 4/11: Stupid Card: tank
public class DCardTheGameDevs extends DsuperCard{
    String initName = "The Game Development Team";
    int initHP = 20;
    int initAtk = 2;
    int initSup = 10;
    int initB = 2;
    String[] moveSet = {"Bad GUI","Late Night Grinding", "Intentionally Placed Bug"};
    int[] applicability = {1, 3, 0};//0 is self, 1 is enemy, 2 is ally, 3 is ally and self
    String image = "ICards/GameDevs.png";
    String[] desc = {
        "Look at these losers bro", 
        "[meta joke here]. Deals base damage.", 
        "AAAAHHHHHH. Grants magnitude 1 duration 2 resistance effect on an ally.", 
        "I don't know how to break the fourth wall. Grants magnitude 3 duration 2 regeneration effect on self."
    };

    public DCardTheGameDevs() {
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
            DConditionResistance s = new DConditionResistance(3, "Late Night Grinding", 1);
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
            DConditionRegen s = new DConditionRegen(2, "Intentionally Placed Bug", 3);
            inflictCondition(target, s);
            return(super.sAtk(target));
        }
    }
    
}
