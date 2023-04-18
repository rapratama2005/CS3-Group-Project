//R 4/11: Sample Card to test
public class DSampleCard2 extends DsuperCard{

    public DSampleCard2() {
        super(10, 2, 10, 2, "Sample Man 2", "Sample Attack", "Sample Super Attack", "Sample Stregth Boost", 6, 1, 3, 1);
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
        target.addConditions(sampleStrength);
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
