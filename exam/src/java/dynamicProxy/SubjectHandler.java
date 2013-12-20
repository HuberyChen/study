package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hubery.chen
 * @date (2013-11-17 11:00)
 */
public class SubjectHandler implements InvocationHandler {

    private Subject subject;

    public SubjectHandler(final Subject subject) {
        this.subject = subject;
    }

    @Override
    //proxy.method(args)
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object obj = method.invoke(subject, args);
        System.out.println(System.currentTimeMillis());
        return obj;
    }
}
