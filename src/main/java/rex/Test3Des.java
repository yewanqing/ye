package rex;



import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by sh1 on 16-2-29.
 */
public class Test3Des {
    public static void main(String[] args) throws IOException {
        String msg = "3DES加密解密案例";
        System.out.println("【加密前】：" + msg);
        BASE64Decoder base64Decoder = new BASE64Decoder();

        //加密
        byte[] secretArr = SecretUtils.encryptMode(msg.getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(secretArr);
        System.out.println("【加密后】：" + encode);

        String sec = "eqP0Mm2le18N%2bmGKuyeBSA%3d%3d";
        String strTest = URLDecoder.decode(sec,"UTF-8");
        System.out.println(strTest);
        byte[] byteMi = base64Decoder.decodeBuffer(strTest);
        byte[] myMsgArr = SecretUtils.decryptMode(byteMi);
        String resultStr = new String(myMsgArr, "UTF-8");
        String loginName = "";
        if (resultStr.contains("loginName")) {
            resultStr = resultStr.substring(resultStr.indexOf("loginName"));
            int loginNameBeginIndex = resultStr.indexOf("loginName") + "loginName".length() + 1;
            if (!resultStr.contains("&")) {
                loginName = resultStr.substring(loginNameBeginIndex);
            } else {
                loginName = resultStr.substring(loginNameBeginIndex, resultStr.indexOf("&"));
            }
        }

        System.out.println(loginName);
        //System.out.println("【解密后】：" + new String(myMsgArr));
    }
}
