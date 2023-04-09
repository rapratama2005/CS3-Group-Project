
public abstract class DCondition{
    private int duration;
    private String name;
    public DCondition (int d, String n){
        duration = d;
        name = n;
    }
    //get methods
    public int getDuration(){
        return duration;
    }
    public String getName(){
        return name;
    }
    //set methods
    public int setDuration(int d){
        duration = d;
        return duration;
    }
    public String setName(String n){
        name = n;
        return name;
    }
    //essentials
    public void effect(DsuperCard card){
        duration--;
    };
}