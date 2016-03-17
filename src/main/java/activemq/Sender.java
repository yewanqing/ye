package activemq;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * Created by sh1 on 15-5-30.
 */
public class Sender {
    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // MessageProducer：消息发送者
        MessageProducer producer;
        // TextMessage message;
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.1.216:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
//            destination = session.createQueue("FirstQueue");
//            destination = session.createTopic("FirstTopic");
            destination = session.createQueue("jm.job.message");
            // 得到消息生成者【发送者】
            producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取
            sendMessage(session, producer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer)
            throws Exception {
        for (int i = 1; i <= 100; i++) {
            TextMessage message = session
                    .createTextMessage("appCode:els,class:com.tbc.app.jm.job.domain.Job,corpCode:default,cronExpression:0 0/2 * * * ?,executeStatus:EXECUTE,functionCode:CALCULATE_COMPLETIONRATE,isCycle:true,jobId:aba752baf52d415ca8687c3590153eab,jobLogList:[{class:com.tbc.app.jm.job.domain.JobLog,corpCode:default,createTime:1457255100006,jobId:aba752baf52d415ca8687c3590153eab,jobLogId:0903aa2c2bcb4bc19c5c90b089c59eff,lastModifyTime:1457255100006,optTime:24287585,thisExecuteCount:66914}],jobName:在线人数统计任务,lastModifyTime:1405336200038}");
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
    }
}
