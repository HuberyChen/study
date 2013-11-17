package Exception;

/**
 * @author hubery.chen
 * @date (2013-11-17 23:27)
 */
public class Finally {

    public static void doSomething() {
        try {
            throw new RuntimeException();
        } finally {
//            return;
//            System.exit(0);
//            Runtime.getRuntime().exit(0);
        }
    }

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (RuntimeException e) {
            System.out.println("never arrive here.");
        }
    }
}
