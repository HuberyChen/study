package pratice.test;

import com.quidsi.core.util.IOUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author hubery.chen
 */
public class IOTest {

    @Test
    public void textTest() {
        System.out.println(IOUtils.text(new File("D:\\test.txt")));
    }
}
