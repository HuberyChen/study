package pratice.test;

import org.junit.Test;

public class Pratice {

    @Test
    public void test() {
        // UUID uuid = UUID.randomUUID();
        // System.out.println(uuid);
        // File f = new File("D:/rarTest/java.test/rarTest.zip");
        // System.out.println(f.exists());
        // f.delete();
        // System.out.println(f.getAbsolutePath());
        // try {
        // System.out.println(f.getCanonicalPath());
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println(System.getProperty("user.dir"));
        // System.out.println(f.getParent());
        // System.out.println(f.getPath());

        for (int i = 0; i < 3; i++) {

            if (i == 1) {
                continue;
            } else {
                System.out.println(i);
            }
        }
    }
}
