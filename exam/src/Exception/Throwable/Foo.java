package exception.Throwable;

/**
 * @author hubery.chen
 * @date (2013-11-18 22:53)
 */
public class Foo {

    public static boolean m() {
        StackTraceElement[] sts = new Throwable().getStackTrace();
        for (StackTraceElement st : sts) {
            if (st.getClassName().equals("m1")) {
                return true;
            }
        }
        throw new RuntimeException("In addition to the m1 method, this method does not allow other method calls");
    }

}
