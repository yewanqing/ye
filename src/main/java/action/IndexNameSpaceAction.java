package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.Struts2Utils;

import java.util.HashMap;
import java.util.Map;


public class IndexNameSpaceAction extends ActionSupport {
    public String login(){
        System.out.println("index.nameSpace.login.........");
        Map<String,String> map = new HashMap<String, String>();
        map.put("ye","yeWanQing");
        Struts2Utils.renderJson(map);

        return null;
    }


    public String testSession(){
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("ye","yeWanQing");
//        Struts2Utils.renderJson(map);
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession(); //session
        Struts2Utils.renderJson(session);
        return null;
    }
}
