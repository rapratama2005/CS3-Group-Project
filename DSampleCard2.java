//R 4/11: Sample Card to test
public class DSampleCard2 extends DsuperCard{

    public DSampleCard2() {
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 6);
    }

    @Override
    public String atk(DsuperCard target) {
        target.hurt(super.getAtk());
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        DConditionStrength sampleStrength = new DConditionStrength(2, "Strength", 1);
        this.addConditions(sampleStrength);
        progSup(5);
        return (this.getName() + " used " + this.getBName() + ".");
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
