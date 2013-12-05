package nov.tree.answer.chi;

import nov.tree.Node;
import nov.tree.Tree;
import nov.tree.TreeSerializer;

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
 * @author chi
 */
public class TreeSerializerImpl<T> implements TreeSerializer<T> {
    @Override
    public File serialize(Tree<T> tree) {
        try {
            File file = Files.createTempFile("tree", "dat").toFile();
            if (tree.getRoot() == null) {
                return file;
            } else {
                Deque<Node> nodes = new LinkedList<>();
                Deque<Integer> indexes = new LinkedList<>();

                nodes.push(tree.getRoot());
                indexes.push(1);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

                while (!nodes.isEmpty()) {
                    Node current = nodes.poll();
                    int index = indexes.poll();

                    bufferedWriter.write(String.valueOf(index));
                    bufferedWriter.write(':');
                    bufferedWriter.write((String) current.getValue());
                    bufferedWriter.write('\n');

                    if (current.getLeft() != null) {
                        nodes.addLast(current.getLeft());
                        indexes.addLast(2 * index);
                    }

                    if (current.getRight() != null) {
                        nodes.addLast(current.getRight());
                        indexes.addLast(2 * index + 1);
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
                int p = line.indexOf(":");

                int index = Integer.parseInt(line.substring(0, p));

                Node<T> node = new Node<>((T) line.substring(p + 1));
                Node<T> parent = indexes.get(index / 2);

                if (parent != null) {
                    if (index % 2 == 0) {
                        parent.setLeft(node);
                    } else {
                        parent.setRight(node);
                    }
                }

                indexes.put(index, node);
            }

            reader.close();

            return new Tree(indexes.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}