public class DConditionStrength extends DCondition{
    private int boost;
    public DConditionStrength(int d, String n, int p) {
        super(d, n);
        boost = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.setBoostAtk(card.getBoostAtk()+boost);
        super.effect(card);
    }

}