package thread;

/**
 * Created by sh1 on 15-4-26.
 */
public class InterruptCheck {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Point A: t.isInterrupted()="+t.isInterrupted());
        t.interrupt();
        System.out.println("Point B: t.isInterrupted()="+t.isInterrupted());
        System.out.println("Point C: t.isInterrupted()="+t.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("was not interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }

        System.out.println("Point D: t.isInterrupted()="+t.isInterrupted());

        t.interrupt();
        System.out.println("Point E: t.isInterrupted()="+t.interrupted());
        System.out.println("Point F: t.isInterrupted()="+t.interrupted());



    }

}
