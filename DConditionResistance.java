public class DConditionResistance extends DCondition{
    //if resistance is % chance to not stun even though stun is 100% chance, then we are not doing this
    //the game would just be like rolling a dice to win, that's not fun
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