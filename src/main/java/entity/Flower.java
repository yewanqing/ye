package entity;

/**
 * Created by sh1 on 15-9-5.
 */
public class Flower {
    private int petalCount = 0;
    private String str = "initial value";
    public Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor petalCount = "+petalCount);
    }

    public Flower(String ss){
        System.out.println("Constructor s = "+ss);
        str = ss;
    }

    public Flower(String str,int petals){
        this(petals);
    }

    public Flower(String str,int petals,String ss){
        this(str);
    }
}
