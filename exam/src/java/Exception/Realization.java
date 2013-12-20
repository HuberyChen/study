package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hubery.chen
 * @date (2013-11-17 14:51)
 */
public class Realization {

    public static void doStuff() throws MyException {
        List<Throwable> list = new ArrayList<>();

        try {

        } catch (Exception e) {
            list.add(e);
        }

        try {

        } catch (Exception e) {
            list.add(e);
        }

        if (list.size() > 0) {
            throw new MyException(list);
        }
    }
}
