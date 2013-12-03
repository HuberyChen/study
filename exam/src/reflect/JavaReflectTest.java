package reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class JavaReflectTest {

    @Test
    public void test() {
        Exam exam = new Exam();
        exam.setName("test");

        try {
            // Class c = Class.forName("test.Exam");
            // Method m[] = c.getDeclaredMethods();
            // for (int i = 0; i < m.length; i++)
            //
            // System.out.println(m[i].toString());
            Class<?> myClass = Class.forName("test.Exam");
            Field[] fields = myClass.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(field.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
