package com.effective.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hubery
 */
public final class CaseInsensitiveString {

    private String s;

    public CaseInsensitiveString(String s) {
        if (null == s)
            throw new NullPointerException();
        this.s = s;
    }

    //Broken - violates symmetry
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);

        if (o instanceof String) //One-way interoperability
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));

        List list = new ArrayList();
        list.add(cis);

        System.out.println(list.contains(s));
    }
}
