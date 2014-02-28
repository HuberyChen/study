package pratice.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hubery.chen
 * @date (2013-11-17 11:28)
 */
public class Realization {

    public static void main(String[] args) {
        Subject subject = new RealSubject();

        InvocationHandler handler = new SubjectHandler(subject);

        ClassLoader cl = Subject.class.getClassLoader();

        //handler invoke new RealSubject()
        Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);

        proxy.request();
    }
}
