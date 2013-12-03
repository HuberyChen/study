package test;

import org.junit.Test;

import java.sql.Date;

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

}
