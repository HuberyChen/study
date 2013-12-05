package nov.tree.answer.hubery;

import nov.tree.Tree;
import nov.tree.TreeSerializer;
import nov.tree.TreeTest;
import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author chi
 */
public class TreeSerializerTest {
    TreeSerializer<String> treeSerializer;

    @Before
    public void init() {
        treeSerializer = new TreeSerializerImpl();
    }

    @Test
    public void test() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Tree<String> testData = TreeTest.get();

        File file = treeSerializer.serialize(testData);

        System.out.println("File length:" + file.length());
        System.out.println("Serialize Time:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch.reset().start();

        Tree<String> data = treeSerializer.deserialize(file);
        System.out.println("Deserialize Time:" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        Assert.assertTrue(testData.equals(data));
    }

}
