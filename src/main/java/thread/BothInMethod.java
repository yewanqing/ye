package thread;

/**
 * Created by sh1 on 15-4-26.
 */
public class BothInMethod {
    private String objID;

    public BothInMethod(String objID) {
        this.objID = objID;
    }

    public synchronized void doStuff(int val) {
        print("entering doStuff");
        int num = val * 2 +objID.length();
        print("in doStuff() - local variable num ="+num);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("leaving doStuff()");
    }

    public void print(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println("objID=" + objID + "-" + threadName + ":" + msg);
    }

    public static void main(String[] args) {
        final BothInMethod bim = new BothInMethod("obj1");
        Runnable runA = new Runnable() {
            @Override
            public void run() {
                bim.doStuff(3);
            }
        };

        Thread threadA = new Thread(runA,"threadA");
        threadA.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable runB = new Runnable() {
            @Override
            public void run() {
                bim.doStuff(7);
            }
        };

        Thread threadB = new Thread(runB,"threadB");
        threadB.start();
    }
}
