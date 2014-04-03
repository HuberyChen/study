package pratice.test;

import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntTest {

    @Test
    public void addTest() {
        int a = 1;
        System.out.println(a += a);
    }

    @Test
    public void rangeTest() {

        new Date(Integer.parseInt("23123"), 1, 1);
    }

    @Test
    public void sortTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(0);

        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? 1 : -1;
            }
        });
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

}
