package m11.answer.hubery;

import m11.tree.Node;
import m11.tree.Tree;
import m11.tree.TreeSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hubery.chen
 * @date (2013-11-14 22:44)
 */
public class TreeSerializerImpl implements TreeSerializer {

    private String LEFT_NODE_END = "LEFT_NODE_END";
    private String RIGHT_NODE_END = "RIGHT_NODE_END";

    @Override
    public File serializer(final Tree tree) {
        List<Object> list = new ArrayList<>();
        preOrder(tree.getRoot(), list);
        File outFile = new File("D:/test/tree.txt");
        try (FileOutputStream out = new FileOutputStream(outFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
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
        if (null == p.getLeft()) {
            list.add(LEFT_NODE_END);
        } else {
            preOrder(p.getLeft(), list);
        }
        if (null == p.getRight()) {
            list.add(RIGHT_NODE_END);
        } else {
            preOrder(p.getRight(), list);
        }
    }

    private Object visit(Node p) {
        return p.getValue();
    }

    @Override
    public Tree deserializer(final File file) {
        List<Object> list = new ArrayList<>();
        try (FileInputStream fReader = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fReader)) {
            list = (List<Object>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generateTreeByList(list);
    }

    private Tree<Object> generateTreeByList(List<Object> list) {
        Deque<Object> stack = listConvertToDeque(list);
        if (null == stack && 0 == stack.size()) {
            return null;
        }
        return new Tree<Object>(generateNode(stack));
    }

    private Deque<Object> listConvertToDeque(List<Object> list) {
        if (null == list && list.size() == 0) {
            return null;
        }
        Deque<Object> stack = new LinkedList<>();
        for (Object obj : list) {
            stack.add(obj);
        }
        return stack;
    }

    private Node<Object> generateNode(Deque<Object> stack) {
        Node<Object> node = new Node<Object>(stack.remove());
        if (!stack.getFirst().equals(LEFT_NODE_END)) {
            node.setLeft(generateNode(stack));
        } else {
            stack.remove();
        }
        if (!stack.getFirst().equals(RIGHT_NODE_END)) {
            node.setRight(generateNode(stack));
        } else {
            stack.remove();
        }
        return node;
    }
}
