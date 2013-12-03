package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

    @Test
    public void assignmentTest() {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> testMap = new HashMap<>();
        map.put("1", 1);
        testMap.putAll(map);
        map.put("2", 2);
        if (testMap.isEmpty() && 0 == testMap.size()) {
            System.out.println("testMap is null");
        }
        for (Entry<String, Integer> entry : testMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void getTest() {
        Map<String, Integer> testMap = new HashMap<>();
        System.out.println(testMap.get("2"));
    }

}
