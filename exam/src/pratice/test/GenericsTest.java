package pratice.test;

import org.junit.Test;

/**
 * @author hubery.chen
 */
public class GenericsTest {

    @Test
    public void genericsTest() {
        Generics generics = new Generics("1");
        System.out.println(generics.judgeInstance());
    }

    public class Generics<T> {

        T name;

        public Generics(T t) {
            this.name = t;
        }

        public void setT(T t) {
            this.name = t;
        }

        public T getT() {
            return name;
        }

        public boolean judgeInstance() {
            return name instanceof String;
        }
    }
}
