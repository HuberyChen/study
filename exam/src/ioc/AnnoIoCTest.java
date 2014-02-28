package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hubery.chen
 */
public class AnnoIoCTest {

    public static void main(String[] args) {
        String[] locations = {"beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
        Boss boss = (Boss) ctx.getBean("boss");
        System.out.println(boss);
    }
}
