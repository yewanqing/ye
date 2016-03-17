package rex;

import java.util.List;

/**
 * Created by sh1 on 16-1-7.
 */
public class ClassDemo {
    Class c1 = int.class;
    Class c2 = String.class;

    public static void test(String str) {
        str = "hello";
    }

    public static void main (String args[]) {
        String str = "beijing";
        test(str);
        System.out.println(str);
    }
}
