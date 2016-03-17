package proxy;

/**
 * Created by sh1 on 16-1-5.
 */
public class LogProxy implements MoveAble {
    private MoveAble moveAble;

    public LogProxy(MoveAble moveAble){
        this.moveAble = moveAble;
    }
    @Override
    public void move() {
        System.out.println("日志开始");
        moveAble.move();
        System.out.println("日志结束");
    }

    @Override
    public void getCarName() {

    }
}
