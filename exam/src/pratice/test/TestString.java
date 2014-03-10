package pratice.test;

import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

    @Test
    public void convertTest() {
        int s = 4;
        double ss = (double) s;
        System.out.println(ss);
        System.out.println(s);
    }

    @Test
    public void setTest() {
        Set<String> list = new HashSet<>();
        list.add("1");
        list.add("1");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void stringFormatTest() {
        System.out.println(String.format("%09d", 1111));
    }

    @Test
    public void indexTest() {
        String requestString = "11 11 11";
        int index1, index2;
        index1 = requestString.indexOf(' ');
        index2 = requestString.indexOf(' ', index1 + 1);
        System.out.println(index1);
        System.out.println(index2);
    }
}
