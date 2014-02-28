package pratice.exception.Throwable;

/**
 * @author hubery.chen
 * @date (2013-11-18 22:58)
 */
public class Invoker {

    public static void m1() {
        System.out.println(Foo.m());
    }

    public static void m2() {
        System.out.println(Foo.m());
    }
}
