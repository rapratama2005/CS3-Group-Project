//R 4/11: Sample Card to test
public class DCardDrunkenSailor extends DsuperCard{
    String initName = "Drunken Sailor";
    int initHP = 20;
    int initAtk = 2;
    int initSup = 10;
    int initB = 2;
    String[] moveSet = {"Wild Flail", "Pegleg", "Intoxication"};
    int[] applicability = {1, 1, 1};
    String image = "Ivy.jpg";

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
    }

    @Override
    public String atk(DsuperCard target) {

        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        if (!super.checkSup()){
            return(super.bAtk(target));
        } else {
            return(super.bAtk(target));
        }
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
