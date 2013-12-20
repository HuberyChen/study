package java.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class TestHashMap {

    @Test
    public void test() {
        int size = 30;
        HashMap<Integer, Byte> map = new HashMap<>();
        for (int i = 1; i <= size; i++) {
            map.put(i, (byte) 1);
        }
        map.put(3, (byte) 3);
        map.put(3, (byte) 5);
        System.out.println(map.size());
        System.out.println(Integer.MAX_VALUE);

        Set keySet = map.keySet();
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            byte val = map.get(key);
            System.out.println(key + " " + val);
        }
    }

}
