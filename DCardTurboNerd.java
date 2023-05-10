//R 4/11: Turbo Nerd - Tank
public class DCardTurboNerd extends DsuperCard{
    String initName = "Turbo Nerd";
    int initHP = 20;
    int initAtk = 2;
    int initSup = 8;
    int initB = 2;
    String[] moveSet = {"Umm Ackshually","The Quadratic Equation", "The power of GOD and ANIME on my side"};
    int[] applicability = {1, 0, 0};
    String image = "ICards/TurboNerd.png";
    String[] desc = {
        "Be careful who you make fun of in school. Actually, don't. It's way funnier this way.",
        "*insert nerdy rant here*. Deals base damage.", 
        "'Negative B plus or minus the square root of B squared minus 4 A C all over 2 A'. Grants a resistance effect of duration 3 and magnitude 3", 
        "*I don't watch anime, pretend there's a cool catchphrase here*. Grants a regeneration effect of duration 2 and magnitude 5."
    };

    public DCardTurboNerd() {
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
            DCondition s = new DConditionResistance(3, "Quadratic Equation", 1);
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
            DCondition s = new DConditionRegen(2, "The Power of GOD and ANIME", 5);
            target.addConditions(s);
            return(super.sAtk(target));
        }
    }
    
}
