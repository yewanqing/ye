package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sh1 on 16-1-5.
 */
public class LogProxyHandler implements InvocationHandler {
    private Object obj;

    public static Object newInstance(Object obj)
    {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new LogProxyHandler(obj));
    }

    private LogProxyHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try
        {
            System.out.println("--before method " + method.getName());
            result = method.invoke(obj, args);
        }
        catch(InvocationTargetException e)
        {
            throw e.getTargetException();
        }
        catch(Exception e)
        {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        finally
        {
            System.out.println("--after method " + method.getName());
        }
        return result;
    }
}
