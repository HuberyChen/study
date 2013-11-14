package m11.tree;

/**
 * @author chi
 */
public class Tree<T> {
    Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public boolean equals(Tree<T> that) {
        return equals(root, that.root);
    }

    public boolean equals(Node<T> node, Node<T> another) {
        if (node == null || another == null) {
            return node == another;
        }

        if (node.value.equals(another.value)) {
            return equals(node.left, another.left) && equals(node.right, another.right);
        }

        return false;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(final Node<T> root) {
        this.root = root;
    }
}
