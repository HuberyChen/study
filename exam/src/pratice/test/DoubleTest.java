package pratice.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hubery.chen
 */
public class DoubleTest {

    @Test
    public void getTest() {
        Double num = null;
        num = 123D;
        if (null != num && 0D != num) {
            System.out.println("failure");
        }
        System.out.println("success");
    }

    @Test
    public void convertTest() {
        Double.parseDouble("s");
    }

    @Test
    public void transmitTest() {
        double test = 0D;
        changeValue(test);
        System.out.println(test);
    }

    @Test
    public void doubleTest() {
        Double leaveAmount = 12.5D;
        System.out.println(new BigDecimal(leaveAmount).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    @Test
    public void compareTest() {
        Double test1 = 10.000000001D;
        Double test2 = null;
        System.out.println(Double.compare(test1, test2));
    }

    private void changeValue(double test) {
        test = test + 1D;
    }
}
