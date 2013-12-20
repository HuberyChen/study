package staticProxy;

/**
 * @author hubery.chen
 * @date (2013-11-17 10:52)
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject");
    }
}
