package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by sh1 on 14-11-6.
 */
public class MyInterceptor2 extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("intercept2 start");
        String result = invocation.invoke();
        System.out.println("intercept2 finish");
        return result;
    }
}
