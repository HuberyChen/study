package pratice.test;

import org.junit.Test;

public class ObjectTest {

    @Test
    public void test() {
        MyInteger a = new MyInteger(0);
        this.changeValue(a);
        System.out.println(a);
    }

    public void changeValue(MyInteger number) {
        number.setValue(1);
    }

    static public class MyInteger {
        private Integer value;

        public void add(Integer number) {
            value += number;
        }

        public MyInteger(Integer value) {
            super();
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String toString() {
            return value.toString();
        }

    }

}
