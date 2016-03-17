package util;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by sh1 on 15-6-2.
 */
public class Test {
    public static void main(String[] args) {
//        String organizeNamPathTmp = "1.2.3.4.5";
//        SortedSet<String> organizeNamPathSet = new TreeSet<String>();
//        while (organizeNamPathTmp.contains(".")) {
//            int lastIndex = organizeNamPathTmp.lastIndexOf(".");
//            organizeNamPathTmp = organizeNamPathTmp.substring(0, lastIndex);
//            organizeNamPathSet.add(organizeNamPathTmp);
//        }
//        organizeNamPathSet.add("1.2.3.4.5");
//        System.out.println(organizeNamPathSet);
//        for (String s : organizeNamPathSet) {
//            System.out.println(s);
//        }

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        b(list);
//        System.out.println(list.size()+"++++++++++++");
        try {
         int i=   1/0;
        }catch (Exception e){}
        finally {
            System.out.println("1111");
        }
        System.out.println("2222");
    }

    public static void b(List<String> cs) {
        cs.add("3");
    }
}
