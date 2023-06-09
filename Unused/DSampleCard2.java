package Unused;
//R 4/11: Sample Card to test

import DConditionStrength;
import DsuperCard;

public class DSampleCard2 extends DsuperCard{
    String initName = "Sample Man 2";
    int initHP = 10;
    int initAtk = 2;
    int initSup = 6;
    int initB = 2;
    String[] moveSet = {"Sample Attack","Sample Strength Boost", "Sample Super Attack"};
    int[] applicability = {1, 3, 1};
    String image = "Ivy.jpg";

    public DSampleCard2() {
        super(10, 2, 10, 2, "Sample Man 2", "Sample Attack", "Sample Super Attack", "Sample Stregth Boost", 6, 1, 3, 1, 2, "Ivy.jpg");
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
