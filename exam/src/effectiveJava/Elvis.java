package effectiveJava;

import java.io.ObjectStreamException;

/**
 * @author hubery
 */
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private static final Elvis INSTANCE_FACTORY = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE_FACTORY;
    }

    //readResolve method to preserve singleton property
    private Object readResolve() throws ObjectStreamException {

        //Return the one true Elvis and let the garbage collector take care of the Elvis impersonator
        return INSTANCE;
    }
}
