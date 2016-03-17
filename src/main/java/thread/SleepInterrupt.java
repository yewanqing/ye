package thread;

import action.Test;

/**
 * Created by sh1 on 15-4-26.
 */
public class SleepInterrupt implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("in run() - about to sleep for 10 seconds");
            Thread.sleep(10000);
            System.out.println("in run() - work up");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted while sleeping");
            return;
        }

        System.out.println("in run() - doing stuff after sleep");
        System.out.println("in run() -leaving normally");

    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread t = new Thread(si);
        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main() - interrupting other thread");
        t.interrupt();
        System.out.println("in main() - leaving");
    }

}
