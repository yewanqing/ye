package mail;

/**
 * Created by sh1 on 16-3-14.
 */
public class SendEmailMessage {
    private String type; // 格式类型，如 text/html;charset=gbk
    private String from; // 发送人
    private String subject; // 标题
    private String text; // 内容
    private String recipient; // 接收人，多个接收人用逗号分隔
    private String datetime; // 发送时间


    public String getFrom() {
        return from;
    }


    public void setFrom(String from) {
        this.from = from;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public String getRecipient() {
        return recipient;
    }


    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }


    public String getDatetime() {
        return datetime;
    }


    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
}
