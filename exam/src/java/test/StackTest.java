package java.test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackTest {

    @Test
    public void removeTest() {
        Deque<Object> stack = new LinkedList<>();
        stack.add("123");
        stack.add("1111");
        System.out.println(stack.size());
        System.out.println(stack.getFirst());
        System.out.println(stack.size());
    }

}
