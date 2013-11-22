package m11.answer.hubery;

import m11.tree.Node;
import m11.tree.Tree;
import m11.tree.TreeSerializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author hubery.chen
 * @date (2013-11-14 22:44)
 */
public class TreeSerializerImpl<T> implements TreeSerializer<T> {

    private String LEFT_NODE_END = "LEFT_NODE_END";
    private String RIGHT_NODE_END = "RIGHT_NODE_END";

    @Override
    public File serialize(Tree<T> tree) {
        try {
            File file = Files.createTempFile("tree", "dat").toFile();
            if (tree.getRoot() == null) {
                return file;
            } else {
                Deque<Node> nodes = new LinkedList<>();

                nodes.push(tree.getRoot());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

                while (!nodes.isEmpty()) {
                    Node current = nodes.poll();

                    bufferedWriter.write((String) current.getValue());
                    bufferedWriter.write('\n');

                    if (current.getLeft() != null) {
                        nodes.addLast(current.getLeft());
                    } else {
                        bufferedWriter.write(LEFT_NODE_END);
                        bufferedWriter.write('\n');
                    }

                    if (current.getRight() != null) {
                        nodes.addLast(current.getRight());
                    } else {
                        bufferedWriter.write(RIGHT_NODE_END);
                        bufferedWriter.write('\n');
                    }
                }

                bufferedWriter.close();
                return file;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Tree deserialize(File file) {
        Map<Integer, Node<T>> indexes = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

                Node<T> node = new Node<>((T) line.substring(0));
            }

            reader.close();

            return new Tree(indexes.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
