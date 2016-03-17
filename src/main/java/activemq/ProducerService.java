package activemq;

import javax.jms.Destination;

/**
 * Created by sh1 on 15-5-31.
 */
public interface ProducerService {
    void sendMessage(final String message);
}
