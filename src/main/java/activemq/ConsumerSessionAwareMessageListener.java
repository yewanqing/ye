package activemq;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by sh1 on 16-1-28.
 */
@Service("consumerSessionAwareMessageListener")
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {
    @Resource
    private Destination queueDestination;
    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
        System.out.println("收到一条消息");
        System.out.println("消息内容是：" + message.getText());
        MessageProducer producer = session.createProducer(queueDestination);
        Message textMessage = session.createTextMessage("ConsumerSessionAwareMessageListener。。。");
        producer.send(textMessage);
    }
}
