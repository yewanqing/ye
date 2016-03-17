package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by sh1 on 14-11-6.
 */
public class MyInterceptor1 implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("intercept1 start");
        String result = invocation.invoke();
        System.out.println("intercept1 finish");
        return result;
    }
}
