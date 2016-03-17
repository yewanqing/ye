package remote;

import com.tbc.paas.common.utils.MD5Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sh1 on 16-1-19.
 */
public class HttpTest {
    public static void main(String[] args) {
        String url = "http://115.239.135.2:8112/userLoginAuthentication.htm";
        String eid = "10000512";
        String pwd = "123456";
        String userId = "test002";
        String sid = MD5Generator.getHexMD5(eid + userId + pwd);
        StringBuffer fullUrl = new StringBuffer(url);
        fullUrl.append("?eid="+eid);
        fullUrl.append("&userId="+userId);
        fullUrl.append("&sid="+sid);
        System.out.println(fullUrl.toString());
        Map<String,String> map = new HashMap<String, String>(5);
    }
}
