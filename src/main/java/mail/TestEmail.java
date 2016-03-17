package mail;

/**
 * Created by sh1 on 16-3-14.
 */
public class TestEmail {
    public static void main(String[] args) throws Exception {
// 默认情况下，在这里输入QQ号和密码，便可收信与发信
        EmailUtil eu = new EmailUtil("yewanqing@21tb.com", "sh21tb");
//        SendEmailMessage sem = new SendEmailMessage();
//        sem.setFrom("wzz<xxx@gmail.com>");
//        sem.setRecipient("xxx@qq.com,zzz@163.com");
//        sem.setSubject("镇长");
//        sem.setText("hello world");
//        eu.sendMail(DefaultConfigure.getSMTP(), sem);
//        System.out.println("发送成功");
// 收邮件
//        eu.receiveMail(DefaultConfigure.getPOP3(), "pop3"); // pop3收信
//        System.out.println("收取完毕");
// 使用IMAP收信会抛出 Failed to load IMAP envelope 异常
eu.receiveMail(DefaultConfigure.getIMAP(), "imap"); // imap收信
    }
}
