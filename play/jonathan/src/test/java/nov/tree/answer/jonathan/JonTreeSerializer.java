package nov.tree.answer.jonathan;

import nov.tree.Node;
import nov.tree.Tree;
import nov.tree.TreeSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jonathan.Guo    13-11-14
 */
public class JonTreeSerializer implements TreeSerializer {

    private String rootSign = "R";
    private String leftSign = "l";
    private String rightSign = "r";

    private Map<String, Object> nodes;

    @Override
    public File serialize(Tree tree) {
        nodes = new HashMap<>();
        putTreeInMap(tree, rootSign);
        Date date = new Date();
        File file = new File("d:\\tree-" + date.getMinutes() + date.getSeconds() + ".tree");
//        printTree();
        StringBuilder b = new StringBuilder();
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, Object> entry : nodes.entrySet()) {
                b.setLength(0);
                b.append("\"").append(entry.getKey()).append("\",\"");
                b.append(entry.getValue().toString()).append("\"|");
                writer.write(b.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    private void printTree() {
        List<String> list = new ArrayList<>(nodes.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? 0 : o1.length() < o2.length() ? 1 : -1;
            }
        });
        int pre = Integer.MAX_VALUE;
        StringBuilder b = new StringBuilder();
        for (String name : list) {
            b.append("-----");
            b.append(nodes.get(name));
            if (name.length() < pre) {
                System.out.println();
            }
            System.out.print(b.toString());
            b.setLength(0);
            pre = name.length();
        }
    }

    private void putTreeInMap(Tree tree, String name) {
        Node node = tree.getRoot();
        nodes.put(name, node.getValue());
        putNextNodes(node, name);
        System.out.println("cut the tree into pieces and collect in map over");
    }

    private void putLeftNode(Node node, String name) {
        name += leftSign;
        nodes.put(name, node.getValue());
        putNextNodes(node, name);
    }

    private void putRightNode(Node node, String name) {
        name += rightSign;
        nodes.put(name, node.getValue());
        putNextNodes(node, name);
    }

    private void putNextNodes(Node node, String name) {
        if (node.getLeft() != null) {
            putLeftNode(node.getLeft(), name);
        }
        if (node.getRight() != null) {
            putRightNode(node.getRight(), name);
        }
    }

    @Override
    public Tree deserialize(File file) {
        nodes = new HashMap<>();
        int tempChar;
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            StringBuilder b = new StringBuilder();
            while ((tempChar = reader.read()) != -1) {
                if ((char) tempChar == '|') {
                    restoreMap(b.toString());
                    b.setLength(0);
                } else {
                    b.append((char) tempChar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        printTree();
        Node root = grow(rootSign);
        return new Tree(root);
    }

    private void restoreMap(String seed) {
        StringBuilder b = new StringBuilder();
        String[] seeds = seed.split(",");
        nodes.put(seeds[0].substring(seeds[0].indexOf('\"') + 1, seeds[0].lastIndexOf("\"")), seeds[1].substring(seeds[1].indexOf('\"') + 1, seeds[1].lastIndexOf("\"")));

    }

    private Node grow(String name) {
        Node node = new Node(nodes.get(name));
        if (nodes.containsKey(name + leftSign)) {
            node.setLeft(grow(name + leftSign));
        }
        if (nodes.containsKey(name + rightSign)) {
            node.setRight(grow(name + rightSign));
        }
        return node;
    }

}
