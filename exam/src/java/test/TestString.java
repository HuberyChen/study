package java.test;

import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.regex.Pattern;

public class TestString {

    @Test
    public void dateTest() {
        Date date = new Date();
        System.out.println(date.getMonth());
    }

    @Test
    public void stringTest() {
        File file = new File("D:\\java.test");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test() {
        String s = "��hello";
        boolean a = s.matches(".*[\u4e00-\u9faf].*");
        System.out.println(a);
    }

    @Test
    public void regularTest() {
        // Pattern p = Pattern.compile("\\D*.2013-10-18_\\d*\\.\\D*");
        Pattern p = Pattern.compile("[\\S\\|\\s]*action[\\S\\|\\s]*");
        File file = new File("\\\\sharedoc\\�ļ�������\\Java-Team\\prod log\\giftco-service\\Prod-gcsvc2\\2013\\10\\21\\action\\giftco-service-action.2013-10-30_00.log");
        String parent = file.getParent();
        System.out.println(p.matcher(parent).matches());
    }

    @Test
    public void circulationTest() {
        for (int i = 0; i < 5; i++) {
            if (3 != i) {
                continue;
            }
            System.out.println(i);
        }
    }
}
