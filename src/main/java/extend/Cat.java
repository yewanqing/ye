package extend;

/**
 * Created by sh1 on 15-12-1.
 */
public class Cat extends Animal {
    private String name = "cat";

    {

        System.out.println("This cat piece!");
    }
    {

    }
    public Cat(){
        super();
        System.out.println("Cat name is "+name);
        System.out.println("This cat constructor!");
    }

    public Cat(String str){
        super();
    }

    public Student play(){
        return null;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}
