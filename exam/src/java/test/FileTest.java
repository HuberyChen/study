package java.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hubery.chen
 */
public class FileTest {

    @Test
    public void deleteTest() throws IOException {
        File file = new File("D:\\java.test.txt");
        file.delete();
    }
}
