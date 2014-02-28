package pratice.enumeration;

import org.junit.Test;

public class EnumTest {

    @Test
    public void enumTest() {
        CarFactory.BuickCar.create();
        VendorConfigurationType type = VendorConfigurationType.FI;
        System.out.println(type.getType());
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
