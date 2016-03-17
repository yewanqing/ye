package extend;

/**
 * Created by sh1 on 15-9-9.
 */
public class Art {
    public int filed = 0;
    public int getFiled(){
        return filed;
    }

    private  String name = "yewanqing";
    static {
        System.out.println("Art static");
    }
    public Art(){
        System.out.println("Art constructor");
    }

    static {
        System.out.println("Art after constructor static");
    }
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
//        Art art = new Drawing();
//        System.out.println(art.name);
//        art.f();
        String str = "ye,";
        System.out.println(str.substring(0,str.length()-1));
    }
}
