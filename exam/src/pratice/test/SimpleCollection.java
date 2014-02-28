package pratice.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleCollection {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");

        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
            if (s.equals("Test3")) {
                System.out.println(s);
                it.remove();
            }
        }

        System.out.println("enter");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
