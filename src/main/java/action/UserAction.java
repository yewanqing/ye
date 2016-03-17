package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import util.Struts2Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String loadUser(){
        System.out.println(name);
        System.out.println("user.loadUser....");
        name ="wang";
        return "login";
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

    @Override
    public User getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
