package pratice.exception.construction;

import java.io.IOException;

/**
 * @author hubery.chen
 * @date (2013-11-17 23:44)
 */
public class Realization {

    public static void main(String[] args) {
        try {
            Base base = new Base();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
