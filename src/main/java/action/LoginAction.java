package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import spring.UserService;
import util.Struts2Utils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;


public class LoginAction extends ActionSupport {
    private static final Log LOG = LogFactory.getLog(LoginAction.class);
    @Resource
    private UserService userService;

    public String login() {
//        userService.save();
        for (int i = 0; i <= 100; i++) {
            LOG.info("log"+i);
        }
        System.out.println("login.login.........");
        Map<String, String> map = new HashMap<String, String>();
        map.put("ye", "yeWanQing");
        Struts2Utils.renderJson(map);

        return null;
    }


    public String testSession() {
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("ye","yeWanQing");
//        Struts2Utils.renderJson(map);
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession(); //session
        Struts2Utils.renderJson(session);
        return null;
    }
}
