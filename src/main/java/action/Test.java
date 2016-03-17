package action;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sh1 on 15-1-7.
 */
public class Test extends Thread{
    public Test() {

    }

    public void run() {
        for (int i = 0 ; i < 100 ; i ++) {
            try {
                Thread.sleep(100) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main (String args[]) {
        Test test = new Test() ;
        test.setDaemon(true) ;
        test.start() ;
        System.out.println("isDaemon=" + test.isDaemon());
        try {
            System.in.read() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
