package pratice.random;

import java.util.UUID;

public class MD5Test {

    public static void main(String[] args) {
        String randomString = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            randomString = MD5Create.MD5(UUID.randomUUID().toString());

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(randomString);
    }

}
