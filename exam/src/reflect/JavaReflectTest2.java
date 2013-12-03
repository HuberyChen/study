package reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class JavaReflectTest2 {

    @Test
    public void test() {
        Exam exam = new Exam();
        exam.setName("test");

        try {
            Class<?> myClass = Class.forName("test.Exam");
            Field[] fields = myClass.getFields();

            for (Field field : fields) {
                System.out.println(field.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
