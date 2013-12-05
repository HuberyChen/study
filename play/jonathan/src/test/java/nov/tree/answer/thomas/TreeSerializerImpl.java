package nov.tree.answer.thomas;

import nov.tree.Node;
import nov.tree.Tree;
import nov.tree.TreeSerializer;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Thomas.chen
 */
@SuppressWarnings("unchecked")
public class TreeSerializerImpl<T> implements TreeSerializer<T> {


    @Override
    public File serialize(Tree<T> tree) {
        Node<T> root = tree.getRoot();
        Class<T> entityClass = (Class<T>) root.getValue().getClass();
        TreeWrap<T> treeWrap = new TreeWrap<>(root);
        treeWrap.wrap();
        LinkedList<String> result = treeWrap.Serialize();
        File resultFile = null;
        try {
            resultFile = File.createTempFile("result", ".txt", new File("."));
            resultFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
            return resultFile;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(entityClass.getName());
            writer.newLine();
            for (String line : result) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultFile;
    }

    @Override
    public Tree<T> deserialize(File file) {
        if (!file.exists()) {
            return null;
        }
        LinkedList<String> lines = read(file);
        Node<T> node = null;
        HashMap<String, Node<T>> nodeHashMap = new HashMap<>();
        boolean first = true;
        Class<T> entityClass = null;
        for (String line : lines) {
            if (first) {
                try {
                    entityClass = (Class<T>) Class.forName(line);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                first = false;
                continue;
            }
            int[] indexes = new int[3];
            indexes[0] = line.indexOf(" ");
            indexes[1] = line.indexOf(" ", indexes[0] + 1);
            indexes[2] = line.indexOf(" ", indexes[1] + 1);
            String number = line.substring(0, indexes[0]);
            String leftNumber = line.substring(indexes[0] + 1, indexes[1]);
            String rightNumber = line.substring(indexes[1] + 1, indexes[2]);
            String value = line.substring(indexes[2] + 1);
            T t = getT(value, entityClass);
            node = new Node<>(t);
            if (!"-1".equals(leftNumber)) {
                node.setLeft(nodeHashMap.get(leftNumber));
            }
            if (!"-1".equals(rightNumber)) {
                node.setRight(nodeHashMap.get(rightNumber));
            }
            nodeHashMap.put(number, node);
        }
        return new Tree<>(node);
    }

    private LinkedList<String> read(File file) {
        LinkedList<String> inputList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = reader.readLine()) != null) {
                if ("".equals(data)) {
                    continue;
                }
                inputList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    private T getT(String value, Class<T> entityClass) {
        T t = null;
        try {
            if (entityClass.getName().equals(String.class.getName())) {
                Constructor constructor = entityClass.getConstructor(String.class);
                t = (T) constructor.newInstance(value);
            } else {
                t = entityClass.newInstance();
                Method method = entityClass.getMethod("valueOf", String.class);
                t = (T) method.invoke(t, value);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
