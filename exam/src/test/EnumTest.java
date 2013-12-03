package test;

import org.junit.Test;

public class EnumTest {

    @Test
    public void enumTest() {
        CarFactory.BuickCar.create();
    }

    enum CarFactory {
        FordCar {
            public void create() {
                System.out.println("a new ford car");
            }
        },
        BuickCar {
            public void create() {
                System.out.println("a new buick car");
            }
        };
        public abstract void create();
    }

}
