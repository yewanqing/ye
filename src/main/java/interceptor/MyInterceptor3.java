package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by sh1 on 14-11-6.
 */
public class MyInterceptor3 extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        System.out.println("intercept3 start");
        String result = invocation.invoke();
        System.out.println("intercept3 finish");
        return result;
    }
}
