package mail;

/**
 * Created by sh1 on 16-3-15.
 */
public class Test {
    public static void main(String[] args) {
        String str = "01|总行部门|";
        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split.length);
    }


}
