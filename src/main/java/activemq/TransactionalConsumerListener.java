package activemq;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by sh1 on 16-1-30.
 */
public class TransactionalConsumerListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        System.out.println("接收到一个纯文本消息。");
        try {
            int i =1/0;
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
