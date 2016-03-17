package proxy;

/**
 * Created by sh1 on 16-1-5.
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Person person = new Person();
        LogProxy logProxy = new LogProxy(car);
        TimeProxy timeProxy = new TimeProxy(logProxy);
        timeProxy.move();
        MoveAble moveAble = (MoveAble) LogProxyHandler.newInstance(car);
        moveAble.getCarName();
        CglibProxy cglibProxy = new CglibProxy();
        Person person1 = (Person) cglibProxy.getProxy(Person.class);
        person1.getName();

    }
}
