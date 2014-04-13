package com.effective.java.one_two;

import org.junit.Test;

/**
 * @author hubery
 */
public class StaticMethodTest {

    @Test
    public void staticTest() {
        Boolean a = Boolean.valueOf(true);
        Boolean b = Boolean.valueOf(true);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        a = new Boolean(true);
        b = new Boolean(true);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}

