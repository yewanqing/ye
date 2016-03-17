package rex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sh1 on 15-12-29.
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        Pattern pattern = Pattern.compile("^Java.*");
//        Matcher matcher = pattern.matcher("Java不是人");
//        boolean b= matcher.matches();
//        System.out.println(b);

//        Pattern pattern = Pattern.compile("[,|]+");
//        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
//        }
//        String REG_REGULAR_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
//        String REG_REGULAR_MOBILE = "^(86)?1[1-9]{1}\\d{9}$";
//        String str="8613966389535";
//        Pattern pattern = Pattern.compile(REG_REGULAR_MOBILE);
//        Matcher matcher = pattern.matcher(str);
//        System.out.println(matcher.matches());
        FileWriter writer = new FileWriter("D://insert.sql", true);
        for (int i = 1; i <= 2000; i++) {
            writer.write("INSERT INTO t_ye_user VALUES ('yeZff"+i+"','yeZff"+i+"','yeZff"+i+"@qq.com','yeZff"+i+"','A');");
            writer.write("\n");
        }
        writer.close();

    }

}
