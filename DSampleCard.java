//R 4/11: Sample Card to test
public class DSampleCard extends DsuperCard{

    public DSampleCard() {
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 10);
    }

    @Override
    public void atk(DsuperCard target) {
        target.hurt(super.getAtk());
    }

    @Override
    public void bAtk(DsuperCard target) {
        DConditionPoison samplePoison = new DConditionPoison(3, "Poison", 1);
        target.addConditions(samplePoison);

    }

    @Override
    public void sAtk(DsuperCard target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sAtk'");
    }
    
}
