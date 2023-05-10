package Unused;
public class test{
    public static void main(String[] args){
        // int x=2;
        // while (x>0){
        //     System.out.println("oqwiehf");
        // }
        
        

        //R 4/12: Tested reg atk and b atk 

        DSampleCard2 test1 = new DSampleCard2();
        test1.setName("test 1");
        DSampleCard test2 = new DSampleCard();
        test2.setName("test 2");
        
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("1");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        System.out.println(test1.atk(test2));
        System.out.println(test2.bAtk(test1));
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("2");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        System.out.println(test1.bAtk(test2));
        System.out.println(test2.sAtk(test1));
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("3");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        System.out.println(test1.atk(test2));
        System.out.println(test2.atk(test1));
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("4");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        System.out.println(test2.atk(test1));
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("5");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        System.out.println(test2.sAtk(test1));
        test1.checkConditions();
        test2.checkConditions();
        System.out.println("6");
        System.out.println(test1+"\n");
        System.out.println(test2+"\n");
        
    }
}