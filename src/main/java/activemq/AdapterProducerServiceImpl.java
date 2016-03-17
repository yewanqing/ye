package activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sh1 on 15-5-31.
 */
@Component
@Service("adapterProducerService")
public class AdapterProducerServiceImpl implements ProducerService{
    @Resource
    private JmsTemplate jmsAdapterTemplate;
    @Override
    public void sendMessage(final String message) {
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsAdapterTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(message);
                return session.createMapMessage();
            }
        });
    }
}
