package activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by sh1 on 16-1-30.
 */
@Service("transactionalProducerService")
public class TransactionalProducerServiceImpl implements ProducerService {
    @Resource
    private JmsTemplate jmsTransactionalTemplate;
    @Override
    public void sendMessage(final String message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTransactionalTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
