package thread;

/**
 * Created by sh1 on 15-4-26.
 */
public class PendingInterrupt {
    public static void main(String[] args) {
//        Thread.currentThread().interrupt();
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("Was Not interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }

        System.out.println("elapsedTime=" + (System.currentTimeMillis() - startTime));
    }

}
