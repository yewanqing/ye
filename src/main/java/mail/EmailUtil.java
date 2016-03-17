package mail;
import java.io.UnsupportedEncodingException;

import java.util.Date;

import java.util.Properties;




import javax.mail.Authenticator;

import javax.mail.FetchProfile;

import javax.mail.Folder;

import javax.mail.Message;

import javax.mail.Message.RecipientType;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Store;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeUtility;
/**
 * Created by sh1 on 16-3-14.
 */
public class EmailUtil {
    private String username = null; // 邮箱用户名

    private String password = null; // 邮箱密码


    /**
     * 传入自己的邮箱用户名和密码
     *
     * @param username
     * @param password
     */

    public EmailUtil(String username, String password) {

        this.username = username;

        this.password = password;


    }

    /**

     * 创建连接会话

     * @param props

     * @return

     */

    public Session createSession(Properties props) {


        Session session = Session.getInstance(props, new Authenticator() {

// 返回用户名密码认证

            @Override

            public PasswordAuthentication getPasswordAuthentication() {

                PasswordAuthentication pa = new PasswordAuthentication(username, password);

                return pa;

            }

        });


        return session;

    }




    /**

     * 发送邮件(需设置SMTP)

     * @throws Exception

     */

    public void sendMail(Properties props, SendEmailMessage sem) throws Exception {


        Session session = createSession(props);


// 消息

        Message msg = new MimeMessage(session);

        msg.setFrom(InternetAddress.parse(MimeUtility.decodeText(sem.getFrom()))[0]);

// TO为初级收件人，CC为邮件副本抄送，BCC应该是密秘抄送吧

        msg.setRecipients(RecipientType.TO, InternetAddress.parse(sem.getRecipient()));

        msg.setSubject(sem.getSubject());

        msg.setText(sem.getText());

        msg.setSentDate(new Date());


// 发送消息

        Transport.send(msg);

    }


    /**

     * 接收邮件(需设置POP3或SAMP)

     * @throws Exception

     */

    public void receiveMail(Properties props, String protocol) throws Exception {


        Session session = createSession(props);

        Store store = session.getStore(protocol);

        store.connect(); // 连接

        Folder inbox = store.getFolder("INBOX"); // 进入根目录

        inbox.open(Folder.READ_WRITE); // 只读方式

        FetchProfile profile = new FetchProfile();

        profile.add(FetchProfile.Item.ENVELOPE); // 获取信封

        Message[] msgs = inbox.getMessages(); // 得到所有邮件

        inbox.fetch(msgs, profile); // 预获取信息

// 打印

        for (int i = 0; i < msgs.length; i++) {

            System.out.println("发送时间：" + msgs[i].getSentDate());

            System.out.println("发送人：" + decodeText(msgs[i].getFrom()[0].toString()));

            System.out.println("大小：" + msgs[i].getSize());

            System.out.println("标题：" + msgs[i].getSubject());

            System.out.println("内容" + msgs[i].getContent());

            System.out.println("-------------------");

        }


        store.close();

    }


    /**

     * 处理中文编码问题

     * @param text

     * @return

     * @throws UnsupportedEncodingException

     */

    private String decodeText(String text) throws UnsupportedEncodingException {


        if (text == null) {

            return null;

        }


        if (text.startsWith("=?GB") || text.startsWith("=?gb"))

            text = MimeUtility.decodeText(text);

        else

            text = new String(text.getBytes("ISO8859_1"));

        return text;

    }



}
