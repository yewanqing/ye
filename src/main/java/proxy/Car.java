package proxy;

/**
 * Created by sh1 on 16-1-5.
 */
public class Car implements MoveAble {
    @Override
    public void move() {
        try {
            Thread.sleep(5000);
            System.out.println("汽车行驶中");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCarName() {
        System.out.println("Car Name: BWM");
    }
}
