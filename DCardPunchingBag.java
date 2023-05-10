//R 4/11: Punching Bag - Tank and test bot
public class DCardPunchingBag extends DsuperCard{
    String initName = "Punching Bag";
    int initHP = 30;
    int initAtk = 2;
    int initSup = 4;
    int initB = 2;
    int lastHit;
    int absorbedDamage = 0;
    String[] moveSet = {"Light Jab","Absorb Hit", "Equal and Opposite Reaction"};
    int[] applicability = {1, 0, 1};
    String image = "ICards/PunchingBag.png";
    String[] desc = {
        "Is it a bag FOR punching or a bag THAT punches?", 
        "Don't ask me how. Deals base damage.", 
        "Adds the amount of damage from the last hit to a Super Attack. Then heals 2 health", 
        "Thanks, Newton! Deals stored damage from 'Absorb Hit'"};

    public DCardPunchingBag() {
        super(10, 2, 10, 2, "Sample Man", "Sample Attack", "Sample Super Attack", "Sample Poison Attack", 6, 1, 1, 1, 2, "Ivy.jpg");
        super.setName(initName);
        super.setHealth(initHP);
        super.setMaxH(initHP);
        super.setAtk(initAtk);
        super.setMaxA(initAtk);
        super.setAName(moveSet[0]);
        super.setBName(moveSet[1]);
        super.setSName(moveSet[2]);
        super.setSupReq(initSup);
        super.setBReq(initB);
        super.setImgSource(image);
        super.setAtkApplicability(applicability[0]);
        super.setBAtkApplicability(applicability[1]);
        super.setSAtkApplicability(applicability[2]);
        super.setApplicabilityArray(applicability);
        super.setDesc(desc);
    }

    @Override
    public String atk(DsuperCard target) {
        /*
         * Attack Desc
         * 
         */
        target.hurt(super.getAtk());
        progSup(super.getAtk());
        return (this.getName() + " used " + this.getAName() + " on " + target.getName() + " for " + this.getAtk() + " damage.");
    }

    @Override
    public String bAtk(DsuperCard target) {
        /*
         * B Attack Desc
         * 
         */
        if (!super.checkB()){
            return(super.bAtk(target));
        } else {
            absorbedDamage += lastHit;
            heal(2);
            return(super.bAtk(target));
        }
    }

    @Override
    public String sAtk(DsuperCard target) {
        /*
         * S Attack Desc
         * 
         */
        if (!super.checkSup()){
            return(super.sAtk(target));
        } else {
            target.hurt(absorbedDamage);
            return(super.sAtk(target));
        }
    }

    @Override
    public int hurt(int damage){
        lastHit = damage;
        super.hurt(damage);
        return(damage);
    }
    
}
