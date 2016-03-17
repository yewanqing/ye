package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.*;


public class ParseMimeMessage {
    private MimeMessage mimeMessage = null;
    private String saveAttachPath = "";//附件下载后的存放目录
    private StringBuffer bodyText = new StringBuffer();

    /**
     * 构造函数,初始化一个MimeMessage对象
     */
    public ParseMimeMessage() {
    }

    public ParseMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }


    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }


    /**
     * 获得发件人的地址和姓名
     */
    public String getFrom() throws Exception {
        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
        String from = address[0].getAddress();
        if (from == null) from = "";
        String personal = address[0].getPersonal();
        if (personal == null) personal = "";
        return personal + "<" + from + ">";
    }

    /**
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同
     * "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址
     */
    public String getMailAddress(String type) throws Exception {
        String addType = type.toUpperCase();
        if (!addType.equals("TO") && !addType.equals("CC") && !addType.equals("BCC")) {
            throw new Exception("Error emailAddress type!");
        }

        InternetAddress[] addresses;
        if (addType.equals("TO")) {
            addresses = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.TO);
        } else if (addType.equals("CC")) {
            addresses = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.CC);
        } else {
            addresses = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.BCC);
        }

        String mailAddress = "";
        for (InternetAddress address : addresses) {
            String email = address.getAddress();
            if (email == null) email = "";
            else {
                email = MimeUtility.decodeText(email);
            }
            String personal = address.getPersonal();
            if (personal == null) personal = "";
            else {
                personal = MimeUtility.decodeText(personal);
            }
            String compositeTo = personal + "<" + email + ">";
            mailAddress += "," + compositeTo;
        }

        mailAddress = mailAddress.substring(1);
        return mailAddress;
    }


    /**
     * 获得邮件主题
     */
    public String getSubject() throws MessagingException {
        String subject = "";
        try {
            subject = MimeUtility.decodeText(mimeMessage.getSubject());
            if (subject == null) {
                subject = "";
            }
        } catch (Exception ignored) {
        }
        return subject;
    }

    /**
     * 获得邮件正文内容
     */
    public String getBodyText() {
        return bodyText.toString();
    }


    /**
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件
     * 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析
     */
    public void getMailContent(Part part) throws Exception {
        String contentType = part.getContentType();
        int nameIndex = contentType.indexOf("name");
        boolean conName = false;
        if (nameIndex != -1) conName = true;
        System.out.println("CONTENTTYPE: " + contentType);
        if (part.isMimeType("text/plain") && !conName) {
            bodyText.append((String) part.getContent());
        } else if (part.isMimeType("text/html") && !conName) {
            bodyText.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                getMailContent(multipart.getBodyPart(i));
            }
        } else if (part.isMimeType("message/rfc822")) {
            getMailContent((Part) part.getContent());
        }
    }

    /**
     * 获得此邮件的Message-ID
     */
    public String getMessageId() throws MessagingException {
        return mimeMessage.getMessageID();
    }


    /**
     * 【判断此邮件是否已读，如果未读返回返回false,反之返回true】
     */
    public boolean hasRead() throws MessagingException {
        boolean hasRead = false;
        Flags flags = (mimeMessage).getFlags();
        Flags.Flag[] flag = flags.getSystemFlags();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == Flags.Flag.SEEN) {
                hasRead = true;
                break;
            }
        }
        return hasRead;
    }


    /**
     * 判断此邮件是否包含附件
     */
    public boolean containAttach(Part part) throws Exception {
        boolean attachFlag = false;
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bodyPart = mp.getBodyPart(i);
                String disposition = bodyPart.getDisposition();
                if ((disposition != null) && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE))))
                    attachFlag = true;
                else if (bodyPart.isMimeType("multipart/*")) {
                    attachFlag = containAttach(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.toLowerCase().contains("application") || contentType.toLowerCase().contains("name")) {
                        attachFlag = true;
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            attachFlag = containAttach((Part) part.getContent());
        }
        return attachFlag;
    }


    /**
     * 【保存附件】
     */
    public String saveAttachment(Part part) throws Exception {
        String fileName;
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bodyPart = mp.getBodyPart(i);
                String disposition = bodyPart.getDisposition();
                if ((disposition != null) && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE)))) {
                    fileName = bodyPart.getFileName();
                    if (fileName.toLowerCase().contains("gb2312")) {
                        fileName = MimeUtility.decodeText(fileName);
                    }
                    return saveFile(fileName, bodyPart.getInputStream());
                } else if (bodyPart.isMimeType("multipart/*")) {
                    saveAttachment(bodyPart);
                } else {
                    fileName = bodyPart.getFileName();
                    if ((fileName != null) && (fileName.toLowerCase().contains("GB2312"))) {
                        fileName = MimeUtility.decodeText(fileName);
                        return saveFile(fileName, bodyPart.getInputStream());
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment((Part) part.getContent());
        }

        return null;
    }


    /**
     * 【设置附件存放路径】
     */
    public void setAttachPath(String attachPath) {
        this.saveAttachPath = attachPath;
    }


    /**
     * 【获得附件存放路径】
     */
    public String getAttachPath() {
        return saveAttachPath;
    }


    /**
     * 【真正的保存附件到指定目录里】
     */
    private String saveFile(String fileName, InputStream in) throws Exception {
        String osName = System.getProperty("os.name");
        String storeDir = getAttachPath();
        String separator;
        if (osName == null) {
            osName = "";
        }

        if (osName.toLowerCase().contains("win")) {
            separator = "\\";
            if (storeDir == null || storeDir.equals("")) {
                storeDir = "C:\\tmp";
            }

        } else {
            separator = "/";
            storeDir = "/tmp";
        }

        String filePath = storeDir + separator + fileName;
        File storeFile = new File(filePath);
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(storeFile));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
                bos.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("文件保存失败!");
        } finally {
            if (null != bos) {
                bos.close();
            }

            if (null != bis) {
                bis.close();
            }
        }

        return filePath;
    }

}

