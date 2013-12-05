package nov.tree.answer.thomas;

import nov.tree.Node;

/**
 * @author Thomas.chen
 */
@SuppressWarnings("UnusedDeclaration")
public class NodeWrap<T> {

    static int count = 0;
    int number;
    int leftNumber = -1;
    int rightNumber = -1;
    T value;
    NodeWrap<T> left;
    NodeWrap<T> right;

    NodeWrap(Node<T> node) {
        this.value = node.getValue();
    }

    NodeWrap(Node<T> node, boolean isCount) {
        this(node);
        if (isCount) {
            this.number = count;
            count++;
        }
    }

    int getLeftNumber() {
        return leftNumber;
    }

    void setLeftNumber(int leftNumber) {
        this.leftNumber = leftNumber;
    }

    int getRightNumber() {
        return rightNumber;
    }

    void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
    }

    NodeWrap<T> getLeft() {
        return left;
    }

    void setLeft(NodeWrap<T> left) {
        this.left = left;
    }

    NodeWrap<T> getRight() {
        return right;
    }

    void setRight(NodeWrap<T> right) {
        this.right = right;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

}
