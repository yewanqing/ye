package remote;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sh1 on 16-1-18.
 */
public class ClientTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("client.xml");
        Business business = (Business)ac.getBean("businessService");
        business.echo("ye");
    }
}
