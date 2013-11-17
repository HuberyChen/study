package Exception.Construction;

import java.io.IOException;

/**
 * @author hubery.chen
 * @date (2013-11-17 23:40)
 */
public class Base {

    public Base() throws IOException {
        throw new IOException();
    }

    public void method() throws Exception{}
}
