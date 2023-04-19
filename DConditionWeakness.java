public class DConditionWeakness extends DCondition{
    int weak;
    public DConditionWeakness(int d, String n, int p) {
        super(d, n);
        weak = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.setBoostAtk(card.getBoostAtk()-weak);
        super.effect(card);
    }

}