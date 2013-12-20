package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hubery.chen
 * @date (2013-11-17 14:48)
 */
public class MyException extends Exception {

    private List<Throwable> causes = new ArrayList<>();

    public MyException(List<? extends Throwable> _causes) {
        causes.addAll(_causes);
    }

    public List<Throwable> getExceptions() {
        return causes;
    }
}
