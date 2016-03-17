package activemq;

import java.util.Map;

/**
 * Created by sh1 on 16-1-28.
 */
public class AdapterConsumerListener {
    public void handleMessage(Map message) {
        System.out.println("AdapterConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(Map message) {
        System.out.println("AdapterConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }
}
