public class DConditionStrength extends DCondition{
    private int boost;
    public DConditionStrength(int d, String n, int p) {
        super(d, n);
        boost = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.setBoostAtk(boost);
        super.effect(card);
    }

}