package proxy;

/**
 * Created by sh1 on 16-1-5.
 */
public class TimeProxy implements MoveAble {
    private MoveAble moveAble;
    public TimeProxy(MoveAble moveAble){
        this.moveAble = moveAble;
    }

    @Override
    public void move() {
        System.out.println("时间开始");
        long start = System.currentTimeMillis();
        moveAble.move();
        System.out.println("时间结束，行驶时间为："+(System.currentTimeMillis()-start));
    }

    @Override
    public void getCarName() {

    }
}
