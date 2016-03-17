package implTest;

import activemq.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * Created by sh1 on 15-5-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerConsumerTest {
    @Resource
    private ProducerService awareProducerService;
    @Resource
    private ProducerService adapterProducerService;
    @Resource
    private ProducerService transactionalProducerService;

    @Resource
    private Destination sessionAwareQueue;
    @Resource
    private Destination adapterQueue;

    @Test
    public void testAwareListener() {
        for (int i=0; i<2; i++) {
            awareProducerService.sendMessage( "你好，生产者！这是消息：" + (i+1));
        }
    }

    @Test
    public void testAdapterListener() {
        for (int i=0; i<2; i++) {
            adapterProducerService.sendMessage("你好，生产者！这是消息：" + (i+1));
        }
    }

    @Test
    public void testTransactionalListener() {
        for (int i=0; i<2; i++) {
            transactionalProducerService.sendMessage("你好，生产者！这是消息：" + (i+1));
        }
    }
}
