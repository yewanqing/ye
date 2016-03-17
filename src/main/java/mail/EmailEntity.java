package mail;

/**
 * Created by sh1 on 16-3-14.
 */

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮件基础实体类
 *
 * @author liuyt
 * @date 2014-10-24 下午2:12:10
 */
public class EmailEntity extends Authenticator {
    /**
     * 用户名（登录邮箱）
     */
    protected static String username;
    /**
     * 密码
     */
    protected static String password;

    /**
     * 初始化邮箱地址和密码
     *
     * @param username 邮箱
     * @param password 密码
     */
    public EmailEntity(String username, String password) {
        EmailEntity.username = "yewanqing@21tb.com";
        EmailEntity.password = "sh21tb";
    }

    /**
     * 重写自我检验方法
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        EmailEntity.password = password;
    }

    public void setUsername(String username) {
        EmailEntity.username = username;
    }
}
