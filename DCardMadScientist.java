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
    String[] desc = {"Character Desc", "Pew Pew Pew!", "B Atk Desc", "S Atk Desc"};

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
        super.setDesc(desc);
    }

    @Override
    public String atk(DsuperCard target) {
        /*
         * Attack Desc
         * Laser Gun
         */
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * Inflicts a random, negative effect for random duration
         */
        if (!super.checkSup()){
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
