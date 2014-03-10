package pratice.test;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public void putTest() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("test2", 2);
        map.put("test1", 1);
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void getTest() {
        Map<String, Map<String, String>> testMap = new HashMap<>();
        Map<String, String> map = testMap.get("2");
        if (CollectionUtils.isEmpty(map)) {
            map = new HashMap<>();
            map.put("2", "2");
            testMap.put("2", map);
        }
        Map<String, String> map1 = testMap.get("2");
        System.out.println(CollectionUtils.isEmpty(map1));
    }

    public static boolean hasText(String text) {
        if (text == null)
            return false;
        for (int i = 0; i < text.length(); i++)
            if (!Character.isWhitespace(text.charAt(i)))
                return true;

        return false;
    }

}
