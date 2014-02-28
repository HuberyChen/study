package pratice.random;

import java.util.UUID;

public class UTest {

    public static void main(String[] args) {
        String randomString;
        long start = System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();
        String s = UUID.randomUUID().toString();
        randomString = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23);
        long end = System.currentTimeMillis();
        System.out.println(uuid);
        System.out.println(randomString);
        System.out.println(end - start);
    }
}
