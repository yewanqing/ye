package remote;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sh1 on 16-1-18.
 */
public class ServerTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("server.xml");
        System.out.println("Server has been started");
    }
}
