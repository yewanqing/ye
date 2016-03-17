package mail;

import com.sun.mail.imap.IMAPMessage;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.unzip.UnzipUtil;
import org.apache.commons.lang.StringUtils;

import javax.mail.*;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.security.Security;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by sh1 on 16-3-14.
 */
public class MailReceiverTest {
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String MAIL_HOST = "mail.21tb.com";
    public static final String MAIL_PORT = "993";
    public static final String USER_NAME = "yewanqing@21tb.com";
    public static final String PASSWORD = "sh21tb";
    public static final String EMAIL_COLLECT_PROTOCOL = "imap";
    private static final String SAVE_FILE_PATH = "D:\\tmp\\email";//附件下载后的存放目录
    public static final String zipFilePwd = "123";

    //存放邮件内容的StringBuffer对象
    public static void main(String[] args) throws Exception {
        collectEmail(EMAIL_COLLECT_PROTOCOL, MAIL_HOST, MAIL_PORT, USER_NAME, PASSWORD,SAVE_FILE_PATH);
    }

    public static void collectEmail(String emailCollect, String mailHost, String mailPort, String userName, String password,String saveFilePath) throws Exception {
        // 准备连接服务器的会话信息
        Store store = getStore(emailCollect, mailHost, mailPort, userName, password);
        store.connect();
        // 获得收件箱
        Folder folder = store.getFolder("INBOX");
        // 以读写模式打开收件箱
        folder.open(Folder.READ_WRITE);
        // 获得收件箱的邮件列表
        Message[] messages = folder.getMessages();
        if (messages == null || messages.length == 0) {
            return;
        }

        IMAPMessage msg = (IMAPMessage) messages[messages.length - 1];
        String subject = MimeUtility.decodeText(msg.getSubject());
        Date receivedDate = msg.getReceivedDate();
        System.out.println(receivedDate + ":" + subject);
        ParseMimeMessage pmm = new ParseMimeMessage(msg);
        boolean hasRead = pmm.hasRead();
        System.out.println(hasRead);
//        if (hasRead) {
//            return;
//        }

        boolean hasAttach = pmm.containAttach((Part)msg);
        System.out.println(hasAttach);
        if (!hasAttach) {
            return;
        }

        msg.setFlag(Flags.Flag.SEEN, true);
        File file = new File(saveFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        pmm.setAttachPath(file.toString());
        String attachmentPath = pmm.saveAttachment(msg);
        folder.close(false);
        store.close();
        if (StringUtils.isEmpty(attachmentPath)) {
            return;
        }

        extractAllFiles(attachmentPath, zipFilePwd, saveFilePath);
        file = new File(attachmentPath);
        file.delete();
    }

    private static Store getStore(String emailCollect, String mailHost, String mailPort, String userName, String password) throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = System.getProperties();
        props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.imap.socketFactory.fallback", "false");
        props.setProperty("mail.imap.port", mailPort);
        props.setProperty("mail.imap.socketFactory.port", mailPort);
        Session session = Session.getDefaultInstance(props, null);
        URLName urlName = new URLName(emailCollect, mailHost, Integer.parseInt(mailPort), null,
                userName, password);
        return session.getStore(urlName);
    }


    public static void extractAllFiles(String zipFilePath, String zipFilePwd, String saveFilePath) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(zipFilePwd);
            }

            List fileHeaderList = zipFile.getFileHeaders();
            for (Object fileHeaderObj : fileHeaderList) {
                FileHeader fileHeader = (FileHeader) fileHeaderObj;
                if (null == fileHeader) {
                    continue;
                }

                String outFilePath = saveFilePath + System.getProperty(FILE_SEPARATOR) + fileHeader.getFileName();
                File outFile = new File(outFilePath);
                File parentDir = outFile.getParentFile();
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                ZipInputStream is = zipFile.getInputStream(fileHeader);
                OutputStream os = new FileOutputStream(outFile);

                int readLen;
                byte[] buff = new byte[4096];
                while ((readLen = is.read(buff)) != -1) {
                    os.write(buff, 0, readLen);
                }

                os.close();
                is.close();
                UnzipUtil.applyFileAttributes(fileHeader, outFile);
                File file = new File(outFilePath);
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
                    String tempString;
                    int line = 1;
                    // 一次读入一行，直到读入null为文件结束
                    while ((tempString = reader.readLine()) != null) {
                        // 显示行号
                        System.out.println("line " + line + ": " + tempString);
                        line++;
                    }

                    reader.close();
                    file.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ignored) {
                        }
                    }
                }

                System.out.println("Done extracting: " + fileHeader.getFileName());
            }
        } catch (ZipException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

