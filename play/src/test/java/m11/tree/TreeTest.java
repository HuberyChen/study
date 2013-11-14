package m11.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chi
 */
public class TreeTest {

    @Test
    public void equal() throws Exception {
        Assert.assertTrue(get().equals(get()));
    }

    public static Tree<String> get() {
        int max = 1000000;

        Node<String> root = new Node<>("value-root");
        Deque<Node<String>> stack = new LinkedList<>();
        stack.addLast(root);

        int counter = 0;

        while (!stack.isEmpty() && counter < max) {
            Node<String> current = stack.pollFirst();
            current.left = new Node<>("value-" + counter++);
            current.right = new Node<>("value-" + counter++);

            stack.addLast(current.left);
            stack.addLast(current.right);
        }

        return new Tree<>(root);
    }
}
