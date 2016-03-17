package mail;


import java.io.File;
import java.io.UnsupportedEncodingException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

/**
 * 邮件发送业务类
 *
 * @author liuyt
 * @date 2014-10-26 上午11:17:45
 */
public class SendEmailService {
    private EmailServiceEnity serviceEnity;

    /**
     * 发送HTML内容邮件 （包括TEXT格式）
     *
     * @throws MessagingException
     */
    public void sendHtmlOrText() throws MessagingException {
        this.send();
    }

    /**
     * 附件发送
     *
     * @param file     java.io.File
     * @param fileName 附件名
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendFile(File file, String fileName) throws MessagingException, UnsupportedEncodingException {
        // 获得Message实例
        Message message = serviceEnity.getMessage();

        // 创建multipart容器用来容纳bodyPart(部件)
        Multipart multipart = new MimeMultipart();

        /**
         * 创建一个BodyPart内容报文
         * 每个消息都有多个部分组成，每个部分是一个BodyPart报文部分，多个BodyPart部分又同时组成一个Multipart的容器
         */
        BodyPart messageBodyPart = new MimeBodyPart();

        // 设置该报文的内容
        messageBodyPart.setContent(serviceEnity.getContent(), serviceEnity.getCONTENT_TYPE_HTML());

        // 添加bodyPart报文部分到multiPart容器
        multipart.addBodyPart(messageBodyPart);

        // 创建一个附件报文
        messageBodyPart = new MimeBodyPart();

        // 文件源
        FileDataSource fds = new FileDataSource(file);

        // 设置邮件的内含附件 （设置数据源为复件）
        messageBodyPart.setDataHandler(new DataHandler(fds));

        // 设置附件的文件名，需进行编码，否则文件名会乱码
        messageBodyPart.setFileName(MimeUtility.encodeText(fileName));

        // 添加到容器
        multipart.addBodyPart(messageBodyPart);

        // 添加报文容器到消息实例
        message.setContent(multipart);

        // 发送消息
        this.send();
    }

    /**
     * 发送
     * 推荐使用方法一，因为方法二如果收件人为多个的话，会为每个人都打开一个Transport通道再关闭
     * 而方法一在发送过程中一直保持连接通常，所有操作完成后才关闭
     *
     * @throws MessagingException
     */
    public void send() throws MessagingException {
        Message message = serviceEnity.getMessage();
        // 方法一
        serviceEnity.getTransport().connect();
        serviceEnity.getTransport().sendMessage(message, message.getAllRecipients());
        serviceEnity.getTransport().close();

        // 方法二
        // Transport.send(this.getMessage());
    }

    // main 方法测试
    public static void main(String[] args) {
        SendEmailService service;
        EmailServiceEnity enity;
        // 多个收件人中间以逗号间隔
        String mailToaddress = "418874847@qq.com,12450374@qq.com";

        // 正文（内容）部分
        String content = "点击进入» <a href='http://www.cnblogs.com/liuyitian'>刘一天的博客</a>";

        try {
            service = new SendEmailService();
            enity = new EmailServiceEnity(mailToaddress, content, EmailServiceEnity.MAIL_PROTOCOL_SMTP);
            service.setServiceEnity(enity);
            service.sendHtmlOrText(); // 测试HTML文本

            /**
             * 切勿使用同一个EmailServiceEnity实例来发送不同内容，如有需要就再初始化一个新实例(否则附件发送失败且乱码)
             * 因为每个实例在发送完邮件后就会关闭Transport
             */
            enity = new EmailServiceEnity(mailToaddress, content, EmailServiceEnity.MAIL_PROTOCOL_SMTP);
            service.setServiceEnity(enity);
            // 传入一个绝对位置的文件路径
            File file = new File("d:/data/adimg/20141022/09/ad_20141022094708943.jpg");
            service.sendFile(file, "测试附件发送.jpg"); // 测试复件发送

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }
    }

    public EmailServiceEnity getServiceEnity() {
        return serviceEnity;
    }

    public void setServiceEnity(EmailServiceEnity serviceEnity) {
        this.serviceEnity = serviceEnity;
    }
}