package action;

import activemq.ProducerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sh1 on 15-12-1.
 */
public class ActiveMqAction extends ActionSupport {
    /**
     * request对象
     */
    protected HttpServletRequest request = ServletActionContext.getRequest();
    /**
     * response对象
     */
    protected HttpServletResponse response = ServletActionContext.getResponse();
    @Resource
    private ProducerService producerService;
    @Resource
    private Destination queueDestination;

    public String sendMessage() throws Exception {
        Map<String, Object> retMap = new HashMap<String, Object>();
        String message = request.getParameter("message");
        for (int i = 0; i <= 50; i++) {
            producerService.sendMessage("消息"+i);
        }
        return "";
    }

}
