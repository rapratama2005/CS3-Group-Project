public class DConditionResistance extends DCondition{
    int boostHp;
    public DConditionResistance(int d, String n, int p) {
        super(d, n);
        boostHp = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.setBoostHealth(card.getBoostHealth()+boostHp);
        super.effect(card);
    }

}