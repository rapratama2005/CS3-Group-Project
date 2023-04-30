import java.util.ArrayList;

public class DTestingCards {
    public static void main (String args[]){
        String a = "";
        int turn = 0;
        int tar;

        DsuperCard enemy = new DCardPunchingBag();
        enemy.setName("Enemy 1");
        enemy.heal(30);
        DsuperCard enemy2 = new DCardPunchingBag();
        enemy2.setName("Enemy 2");
        enemy2.heal(30);
        DsuperCard allied = new DCardPunchingBag();
        allied.setName("Allied 1");
        allied.heal(30);

        DsuperCard toTest = new DCardPunchingBag();
        /* TESTING AGENDA
         * Punching Bag
         * Drunken Sailor
         * Mad Scientist
         * Moral Support Witch
         * Peanut
         */

         ArrayList<DsuperCard> field = new ArrayList<>();
        field.add(enemy);
        field.add(enemy2);
        field.add(allied);
        field.add(toTest);
        //lets have enemy attack on turn 4, 6, and 8 maybe

         //Turn 1 - attempt to use B Attack

         a += "\nTurn 1 - attempt to use B Attack\n";
        turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 1 || turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 1);
        a += field.get(3).bAtk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";

         //Turn 2 - Main Attack
         a += "\nTurn 2 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 3 - Main Attack
         a += "\nTurn 3 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 4 - B Attack
         a += "\nTurn 4 - B Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 1);
        a += field.get(3).bAtk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 5 - Attempt to use Super Attack
         a += "\nTurn 5- Attempt to use Super Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 2);
        a += field.get(3).sAtk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 6 - Main Attack 
         a += "\nTurn 6 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 7 - Main Attack
         a += "\nTurn 7 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 8 - Main Attack
         a += "\nTurn 8 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 9 - Main Attack
         a += "\nTurn 9 - Main Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 0);
        a += field.get(3).atk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
         //Turn 10 - Super Attack
         a += "\nTurn 10 - Super Attack\n";
         turn++;
        for (int i = 0; i < 3; i++){
            field.get(i).checkConditions();
            if((turn == 4 || turn == 6 || turn == 8)&&i==0){
                a += field.get(0).atk(field.get(3)) + "\n";
            }
            a += "\n"+ field.get(i).toString() + "\n";
        }
        field.get(3).checkConditions();
        //put toTest action here
        tar = targetCheck(field.get(3), 2);
        a += field.get(3).sAtk(field.get(tar)) + "\n";
        a += "\n" + field.get(3).toString() + "\n";
        
        //Turn 11 - Conclusion
        a += "\nTurn 11 - Conclusion\n";
        for (int i = 0; i < 4; i++){
            field.get(i).checkConditions();
            a += "\n"+ field.get(i).toString() + "\n";
        }
         
        
        System.out.println(a);
    }

    public static int targetCheck(DsuperCard card, int i){
        if(card.getApplicability(i)==0){
            return 3;
        } else if(card.getApplicability(i)==1){
            return 0;
        } else {
            return 2;
        }
    }
}
