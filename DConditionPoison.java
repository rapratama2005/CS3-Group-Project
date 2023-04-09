public class DConditionPoison extends DCondition{
    private int damage;
    public DConditionPoison(int d, String n, int p) {
        super(d, n);
        damage = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.hurt(damage);
        super.effect(card);
    }

}