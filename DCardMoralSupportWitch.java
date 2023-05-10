//R 4/11: Moral Support Witch - Support
public class DCardMoralSupportWitch extends DsuperCard{
    String initName = "Moral Support Witch";
    int initHP = 10;
    int initAtk = 2;
    int initSup = 8;
    int initB = 2;
    String[] moveSet = {"Minor Electric Bolt","Thaumaturgical Support", "Fulfilling the Prophecy"};
    int[] applicability = {1, 2, 3};
    String image = "ICards/MoralSupportWitch.png";
    String[] desc = {
        "You can do it!", 
        "A SHOCKING revelation! Deals base damage.", 
        "Keep Going! Grants a magnitude 2 resistance effect for duration 3.", 
        "Sending you my energy! Grants an ally a magnitude 5 strength effect for duration 3."};

    public DCardMoralSupportWitch() {
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
            DCondition s = new DConditionResistance(3, "Thaumaturgical Support", 1);
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
            DCondition s = new DConditionStrength(3, "Fulfilling the Prohpecy", 5);
            target.addConditions(s);
            return(super.sAtk(target));
        }
    }
    
}
