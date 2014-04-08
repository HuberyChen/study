package effectiveJava;

/**
 * @author hubery
 */
public class Foo {

    //Sole purpose if this object is to finalize outer Foo object
    private final Object finalizerGuardian = new Object() {
        protected void finalize() throws Throwable {
            //Finalize outer Foo object
        }
    };
}
