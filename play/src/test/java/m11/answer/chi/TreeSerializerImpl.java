package m11.answer.chi;

import m11.tree.Node;
import m11.tree.Tree;
import m11.tree.TreeSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hubery.chen
 * @date (2013-11-14 22:44)
 */
public class TreeSerializerImpl implements TreeSerializer {

    @Override
    public File serializer(final Tree tree) {
        List<Object> list = new ArrayList<>();
        preOrder(tree.getRoot(), list);
        File outFile = new File("D:/test/tree.txt");
        try (FileOutputStream out = new FileOutputStream(outFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);) {
            objectOutputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outFile;
    }

    public void preOrder(Node p, List<Object> list) {
        if (p == null) {
            return;
        }
        list.add(visit(p));
        if (null != p.getLeft()) {
            list.add("EL");
        } else {
            preOrder(p.getLeft(), list);
        }
        if (null != p.getRight()) {
            list.add("ER");
        } else {
            preOrder(p.getRight(), list);
        }
    }

    private Object visit(Node p) {
        return p.getValue();
    }

    @Override
    public Tree deserializer(final File file) {
        try (FileInputStream fReader = new FileInputStream("D:/test/tree.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fReader);) {
            List<Object> list = new ArrayList<>();
            list = (List<Object>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
