package nov.tree.answer.thomas;

import nov.tree.Node;
import nov.tree.Tree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Thomas.chen
 */
@SuppressWarnings("unchecked")
public class TreeWrap<T> extends Tree<T> {

    public NodeWrap<T> rootWrap;

    public TreeWrap(Node<T> root) {
        super(root);
    }

    public void wrap() {
        this.rootWrap = new NodeWrap<>(getRoot(), true);
        LinkedList<Node<T>> stack = new LinkedList<>();
        LinkedList<NodeWrap<T>> stackWrap = new LinkedList<>();
        stack.addLast(getRoot());
        stackWrap.addLast(rootWrap);
        Node<T> head;
        NodeWrap<T> headWrap;
        while ((head = stack.peekLast()) != null) {
            headWrap = stackWrap.peekLast();
            Node<T> node;
            boolean hasChildUnCount = false;
            if ((node = head.getLeft()) != null && headWrap.getLeft() == null) {
                NodeWrap<T> leftWrap = new NodeWrap<>(node, true);
                headWrap.setLeft(leftWrap);
                headWrap.setLeftNumber(leftWrap.getNumber());
                stack.push(node);
                stackWrap.push(leftWrap);
                hasChildUnCount = true;
            } else if ((node = head.getRight()) != null && headWrap.getRight() == null) {
                NodeWrap<T> rightWrap = new NodeWrap<>(node, true);
                headWrap.setRight(rightWrap);
                headWrap.setRightNumber(rightWrap.getNumber());
                stack.push(node);
                stackWrap.push(rightWrap);
                hasChildUnCount = true;
            }
            if (!hasChildUnCount) {
                stack.pollLast();
                stackWrap.pollLast();
            }
        }
    }

    public LinkedList<String> Serialize() {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<NodeWrap<T>> queueWrap = new LinkedList<>();
        queueWrap.push(rootWrap);
        NodeWrap<T> head;
        while ((head = queueWrap.pollLast()) != null) {
            if (head.getLeft() != null) {
                queueWrap.push(head.getLeft());
            }
            if (head.getRight() != null) {
                queueWrap.push(head.getRight());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(head.getNumber());
            stringBuilder.append(" ");
            stringBuilder.append(head.getLeftNumber());
            stringBuilder.append(" ");
            stringBuilder.append(head.getRightNumber());
            stringBuilder.append(" ");
            // TODO:替换回车
            stringBuilder.append(head.getValue().toString());
            result.add(stringBuilder.toString());
        }
        Collections.reverse(result);
        return result;
    }


}
