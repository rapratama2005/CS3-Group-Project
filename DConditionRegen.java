public class DConditionRegen extends DCondition{
    int regen;
    public DConditionRegen(int d, String n, int p) {
        super(d, n);
        regen = p;
    }

    @Override
    public void effect(DsuperCard card) {
        card.heal(regen);
        super.effect(card);
    }

}