package pratice.staticProxy;

/**
 * @author hubery.chen
 * @date (2013-11-17 10:53)
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy() {
        subject = new RealSubject();
    }

    public Proxy(Subject _subject) {
        subject = _subject;
    }

    @Override
    public void request() {
        subject.request();
    }

    public void before() {
        System.out.println(System.currentTimeMillis());
    }

    public void after() {
        System.out.println(System.currentTimeMillis());
    }
}
