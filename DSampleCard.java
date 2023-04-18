//R 4/11: Sample Card to test
public class DSampleCard extends DsuperCard{
    String initName = "Sample Man";
    int initHP = 10;
    int initAtk = 2;
    int initSup = 6;
    String[] moveSet = {"Sample Attack","Sample Poison Attack", "Sample Super Attack"};
    int[] applicability = {1, 1, 1};
    String image = "Ivy.jpg";

    public DSampleCard() {
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 6, 1, 1, 1, "Ivy.jpg");
        super.setName(initName);
        super.setHealth(initHP);
        super.setMaxH(initHP);
        super.setAtk(initAtk);
        super.setMaxA(initAtk);
        super.setAName(moveSet[0]);
        super.setBName(moveSet[1]);
        super.setSName(moveSet[2]);
        super.setSupProg(initSup);
        super.setImgSource(image);
    }

    @Override
    public String atk(DsuperCard target) {
        target.hurt(super.getAtk());
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        DConditionPoison samplePoison = new DConditionPoison(3, "Poison", 1);
        target.addConditions(samplePoison);
        progSup(5);
        return (this.getName() + " used " + this.getBName() + " on " + target.getName() + ".");
    }

    @Override
    public String sAtk(DsuperCard target) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'sAtk'");
        if (!super.checkSup()){
            return(super.sAtk(target));
        } else {
            target.hurt(super.getAtk()*3);
            return(super.sAtk(target));
        }
    }
    
}
