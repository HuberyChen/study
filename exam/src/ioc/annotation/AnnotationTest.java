package ioc.annotation;

import org.junit.Test;

/**
 * @author hubery.chen
 */
public class AnnotationTest {

    @Test
    public void test() {
        Car car = new Car();
        car.setBrand(" 红旗 CA72");
        car.setPrice(2000);
        Office office = new Office();
        office.setOfficeNo("002");
        Boss boss = new Boss();
        boss.setCar(car);
        boss.setOffice(office);
        System.out.println(boss);
    }
}
