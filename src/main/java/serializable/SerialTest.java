package serializable;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class SerialTest {
    public static void main(String[] args) {
        Serial serial1 = new Serial(1, "song");
        System.out.println("Object Serial" + serial1);
        try {
//            FileOutputStream fos = new FileOutputStream("D://serialTest.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(serial1);
//            oos.flush();
//            oos.close();
//            serial1 =null;
            FileInputStream fi = new FileInputStream("D://serialTest.txt");
            ObjectInputStream si = new ObjectInputStream(fi);
            serial1 = (Serial)si.readObject();
            System.out.println(serial1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

